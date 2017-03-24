package com.sg.flooringmastery.ops;

import com.sg.flooringmastery.dao.OrderDao;
import com.sg.flooringmastery.dao.ProductDao;
import com.sg.flooringmastery.dao.ProductDaoFileImpl;
import com.sg.flooringmastery.dao.TaxDao;
import com.sg.flooringmastery.dao.TaxDaoFileImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.ui.ConsoleIO;
import com.sg.flooringmastery.ui.ApplicationUI;
import java.util.ArrayList;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FlooringMasteryController {

    private static Calculations calc = new Calculations();
    private ConsoleIO cons = new ConsoleIO();
    private ApplicationUI ui = new ApplicationUI();
    private OrderDao myOrder;
    private ProductDao myProduct = new ProductDaoFileImpl();
    private TaxDao myTax = new TaxDaoFileImpl();

    public FlooringMasteryController(OrderDao dao) {
        this.myOrder = dao;
    }

    public void run() {
        myTax.loadData();
        ArrayList<Tax> taxList = myTax.retrieveTaxList();
        myProduct.loadData();
        ArrayList<Product> productList = myProduct.retrieveProductList();        
        boolean useApp = true;

        ui.printWelcomeScreen();
        do {
            ui.printMainMenu();
            int selection = cons.readInt("\u25B6 Please select which action "
                    + "you wish to perform:", 1, 6);
            switch (selection) {
                case 1:
                    this.setDateAndSave();
                    break;
                case 2:
                    this.addOrder();
                    break;
                case 3:
                    this.displayOrders();
                    break;
                case 4:
                    this.editOrder();
                    break;
                case 5:
                    this.removeOrder();
                    break;
                case 6:
                default:
                    useApp = false;
                    break;
            }
        } while (useApp);
        ui.printExitMessage();
    }

    private void setDateAndSave() {
        cons.printString("\n=========  SET DATE AND SAVE  =========");

        String date = ui.promptForDate();
        if (!date.isEmpty()) {
            ArrayList<Order> allOrders = myOrder.retrieveAllOrders();
            if (myOrder.checkForExistingFile(date)) {
                cons.printString("\n\u2714 You are appending " + allOrders.size()
                        + " order(s) to the existing file for " + date + ".");
            } else {
                cons.printString("\n\u2714 You are saving " + allOrders.size()
                        + " order(s) for " + date + ".");
            }
            myOrder.saveData(date);
        } else {
            cons.printString("\n\u25B3 ERROR: Unable to save without a valid date.");
        }
    }

    private void displayOrders() {
        cons.printString("\n=========  DISPLAY ALL ORDERS  =========");
        myOrder.retrieveAllOrders().clear();

        String date = ui.promptForDate();
        myOrder.loadData(date);
        if (!myOrder.checkForExistingFile(date)) {
            cons.printString("\n\u25B3 ERROR: No file found for " + date + 
                    ". Returning to main menu.");
        } else {
            ArrayList<Order> allOrders = myOrder.retrieveAllOrders();
            cons.printString("\n\u2714 ORDER COUNT: " + allOrders.size() + 
                    " order(s) found for " + date + ".");
            for (Order order : allOrders) {
                cons.printString(order.toString());
            }
        }
    }

    private void addOrder() {
        cons.printString("\n============  ADD AN ORDER  ============");
        ArrayList<Order> allOrders = myOrder.retrieveAllOrders();

        Order newOrder = promptForOrderInfo();
        if (newOrder == null) {
            cons.printString("\n\u25B3 ERROR: New order not found. "
                    + "Returning to main menu.");
        } else {
            cons.printString("\n\u2714 ORDER TO ADD:" + newOrder.toString());
            String confirmAdd = cons.readString("\n\u25B6 Do you want to add this order? "
                    + "YES or NO:");
            if (confirmAdd.equalsIgnoreCase("YES") || confirmAdd.equalsIgnoreCase("Y")) {
                myOrder.addOrder(newOrder);
            }
        }
    }

    private void editOrder() {
        cons.printString("\n===========  EDIT AN ORDER  ============");
        myOrder.retrieveAllOrders().clear();

        String date = ui.promptForDate();
        myOrder.loadData(date);

        if (!myOrder.checkForExistingFile(date)) {
            cons.printString("\n\u25B3 ERROR: No file found for " + date + 
                    ". Returning to main menu.");
        } else {
            ArrayList<Order> allOrders = myOrder.retrieveAllOrders();

            cons.printString("\n\u2714 ORDER COUNT: " + allOrders.size() + 
                    " order(s) found for " + date + ".");
            for (Order order : allOrders) {
                cons.printString(order.toStringSummary());
            }          
            
            cons.printString("\n\u25B6 Enter the order number to edit:");
            cons.printString("  ORDER NUMBERS CURRENTLY ON FILE FOR " + date + ":");
            ArrayList<String> allOrderNumbers = myOrder.retrieveAllOrderNumbers();
            cons.printString("    " + cons.formatLongArrayToColumns(allOrderNumbers, 9, ", ", ",\n    "));
            int targetEditNumber = cons.readInt();

            Order targetEditOrder = myOrder.findOrder(targetEditNumber);

            if (targetEditOrder == null) {
                cons.printString("\n\u25B3 ERROR: Order number " + targetEditNumber + 
                        " not found. Returning to main menu.");
            } else {
                cons.printString("\n\u2714 Order number " + targetEditNumber + " found:");
                cons.printString(targetEditOrder.toString());

                Order updatedOrder = new Order(targetEditOrder);
                updatedOrder = promptForEditedInfo(updatedOrder);

                cons.printString("\nUPDATED ORDER:" + updatedOrder.toString());
                String confirmEdit = cons.readString("\n\u25B6 Commit this order edit? YES or NO:");
                if (confirmEdit.equalsIgnoreCase("YES") || confirmEdit.equalsIgnoreCase("Y")) {
                    myOrder.updateOrder(targetEditOrder, updatedOrder);
                }
            }
        }
    }

    private void removeOrder() {
        cons.printString("\n==========  REMOVE AN ORDER  ===========");
        myOrder.retrieveAllOrders().clear();

        String date = ui.promptForDate();
        myOrder.loadData(date);

        if (!myOrder.checkForExistingFile(date)) {
            cons.printString("\n\u25B3 ERROR: No file found for " + date + 
                    ". Returning to main menu.");
        } else {
            ArrayList<Order> allOrders = myOrder.retrieveAllOrders();
            
            cons.printString("\n\u2714 ORDER COUNT: " + allOrders.size() + 
                    " order(s) found for " + date + ".");
            for (Order order : allOrders) {
                cons.printString(order.toStringSummary());
            }          

            int targetNumber = cons.readInt("\n\u25B6 Enter the order number to remove:");

            Order targetRemoveOrder = myOrder.findOrder(targetNumber);
            if (targetRemoveOrder == null) {
                cons.printString("\n\u25B3 ERROR: Order number " + targetNumber + 
                        " not found. "
                        + "Returning to main menu.");
            } else {
                cons.printString("\n\u2714 ORDER TO REMOVE:" + targetRemoveOrder.toString());
                String confirmRemove = cons.readString("\n\u25B6 Do you want to remove this order? "
                        + "YES or NO:");
                if (confirmRemove.equalsIgnoreCase("YES") || confirmRemove.equalsIgnoreCase("Y")) {
                    myOrder.removeOrder(targetRemoveOrder);
                }
            }
        }
    }
    
    
    /*  
    *   ----------------------------------------------
    *   BEGIN SUPPORTING METHODS FOR MAIN MENU CHOICES
    *   ----------------------------------------------
    */
    
    private Order promptForOrderInfo() {
//        myTax.loadData();
//        ArrayList<Tax> taxList = myTax.retrieveTaxList();
//        myProduct.loadData();
//        ArrayList<Product> productList = myProduct.retrieveProductList();

        Order order = new Order();
        
        // Order number automatically generated to be maxExistingOrderNumber + 1
        // It's not perfect, but it takes out user guesswork
        int orderNumber = myOrder.generateOrderNumber();
        
        // Customer Name relies on user input
        String customerName = cons.readString("\u25B6 Enter Customer Name:");
        
        // State Name and dependent fields rely on user input and validation against tax list
        String selectedState = promptForState();
        String state = myTax.retrieveState(selectedState);
        double taxRate = myTax.retrieveTaxRate(selectedState);
        
        // Product Type and dependent fields rely on user input and validation against product list
        String productInfo = promptForProduct();
        String productType = myProduct.retrieveProductType(productInfo);
        double materialCostPerSqFoot = myProduct.retrieveMaterialCostPerSqFoot(productInfo);
        double laborCostPerSqFoot = myProduct.retrieveLaborCostPerSqFoot(productInfo);
        
        // Area relies on user input
        double area = Math.abs(cons.readDouble("\n\u25B6 Enter Area "
                + "(in ft\u00B2):", Double.MIN_VALUE, Double.MAX_VALUE));
        
        // Material Cost, Labor Cost, Tax and Total Cost rely on 
        // previously validated fields
        double materialCost = calc.calculateMaterialCost(area, materialCostPerSqFoot);
        double laborCost = calc.calculateLaborCost(area, laborCostPerSqFoot);
        double tax = calc.calculateTax(materialCost, laborCost, taxRate);
        double totalCost = calc.calculateTotalCost(materialCost, laborCost, tax);

        // Set All The Things!
        order.setOrderNumber(orderNumber);
        order.setCustomerName(customerName);
        order.setState(state);
        order.setTaxRate(taxRate);
        order.setProductType(productType);
        order.setArea(area);
        order.setMaterialCostPerSqFoot(materialCostPerSqFoot);
        order.setLaborCostPerSqFoot(laborCostPerSqFoot);
        order.setMaterialCost(materialCost);
        order.setLaborCost(laborCost);
        order.setTax(tax);
        order.setTotalCost(totalCost);

        return order;
    }

    private String promptForState() {
        boolean stateFound = false;
        String state = null;
        do {
            String input = cons.readString("\n\u25B6 Enter 2-character state abbreviation:"
                    + "\n  (For example, Ohio is OH)");
            stateFound = myTax.checkForState(input);

            if (stateFound) {
                state = input.toUpperCase();
            } else {
                cons.printString("\n\u25B3 ERROR: State not in our service area. "
                        + "Please try again.");
            }
        } while (stateFound == false);
        return state;
    }

    private String promptForProduct() {
        boolean productFound = false;
        String productSelection = null;
        do {
            String input = cons.readString("\n\u25B6 Enter product:"
                    + "\n(Products currently on offer: " + 
                    cons.formatArrayToString(myProduct.retrieveProductList()) + ")");
            productFound = myProduct.checkForProduct(input);
            
            if (productFound) {
                productSelection = input;
            } else {
                cons.printString("\n\u25B3 ERROR: Product not currently on offer. "
                        + "Please try again.");
            }
        } while (productFound == false);
        return productSelection;
    }

    private Order promptForEditedInfo(Order targetOrder) {
        Order newOrder = targetOrder;
        cons.printString("\nEDITING MODE: Enter new information for each field, "
                + "or ENTER to keep previous information.\n");
        
        cons.printString("\n\u25B6 Enter New Order Number:"
                + "\n  (or ENTER to keep '" + targetOrder.getOrderNumber() + "')");

        // Enter Order Number
        boolean orderNumberValid = false;
        int newOrderNumber;
        do {
            String newOrderNumberString = cons.readString();
            
            if (newOrderNumberString.isEmpty()) {
                newOrderNumber = targetOrder.getOrderNumber();
                break;
            } else if (!myOrder.checkForExistingOrderNumber(newOrderNumberString)) {

                try {
                    newOrderNumberString = ui.thwartChicanery(newOrderNumberString);
                    newOrderNumber = Integer.parseInt(newOrderNumberString);
                    targetOrder.setOrderNumber(newOrderNumber);
                    orderNumberValid = true;
                } catch (NumberFormatException e) {
                    cons.printString("");
                    newOrderNumber = cons.readInt("\n\u25B3 PROBLEM WITH INPUT: "
                            + "Please enter a valid value for the order number:"
                            + "\n  (or enter a negative number to keep '" + 
                            targetOrder.getOrderNumber() + "')", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    if (newOrderNumber > 0) {
                        targetOrder.setOrderNumber(newOrderNumber);
                    }
                }

            } else {
                cons.printString("\n\u25B3 ERROR: Order number already in file. Please try again.");
            }
        } while (orderNumberValid == false);
        
        // Enter Customer Name
        String newCustomerName = cons.readString("\u25B6 Enter New Customer Name:"
                + "\n  (or ENTER to keep '" + targetOrder.getCustomerName() + "')");
        if (!newCustomerName.isEmpty()) {
            targetOrder.setCustomerName(newCustomerName);
        }
        
        // Enter State and validate
        boolean stateFound = false;
        String newState = null;
        do {
            newState = cons.readString("\u25B6 Enter New State as 2-character state abbreviation:"
                    + "\n  (or ENTER to keep '" + targetOrder.getState() + "')");
            if (!newState.isEmpty()) {
                stateFound = myTax.checkForState(newState);
                if (stateFound) {
                    newState = newState.toUpperCase();
                    targetOrder.setState(newState);
                    break;
                } else {
                    cons.printString("\n\u25B3 ERROR: State not in our service area. "
                            + "Please try again.");
                }
            } else {
                newState = targetOrder.getState();
                break;
            }
        } while (stateFound == false);  

        // Enter Product and validate        
        boolean productFound = false;
        String newProductType = null;
        do {
            newProductType = cons.readString("\u25B6 Enter New Product Type:"
                    + "\n  (or ENTER to keep '" + targetOrder.getProductType() + "')");
            if (!newProductType.isEmpty()) {
                productFound = myProduct.checkForProduct(newProductType);
                if (productFound) {
                    targetOrder.setProductType(newProductType);
                    break;
                } else {
                    cons.printString("\n\u25B3 ERROR: State not in our service area. "
                            + "Please try again.");
                }                
            } else {
                newProductType = targetOrder.getProductType();
                break;
            }
        } while (productFound == false);      
        
        // Enter Area
        double newArea = 0;
        String newAreaString = cons.readString("\u25B6 Enter New Area:"
                + "\n  (or ENTER to keep '" + targetOrder.getArea() + " ft\u00B2')");
        if (!newAreaString.isEmpty()) {
            try {
                newAreaString = ui.thwartChicanery(newAreaString);
                newArea = Double.parseDouble(newAreaString);
                targetOrder.setArea(newArea);
            } catch (NumberFormatException e) {
                newArea = cons.readDouble("\n\u25B3 PROBLEM WITH INPUT: "
                        + "Please enter a valid value for the area:"
                        + "\n  (or enter a negative number to keep '"
                        + targetOrder.getArea() + "%')", Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
                if (newArea > 0) {
                    targetOrder.setArea(newArea);
                }
            }
        } else {
            newArea = targetOrder.getArea();
        }
        
        double newTaxRate = myTax.retrieveTaxRate(newState);
        targetOrder.setTaxRate(newTaxRate);        

        double newMaterialCostPerSqFoot = myProduct.retrieveMaterialCostPerSqFoot(newProductType);
        targetOrder.setMaterialCostPerSqFoot(newMaterialCostPerSqFoot);

        double newLaborCostPerSqFoot = myProduct.retrieveLaborCostPerSqFoot(newProductType);
        targetOrder.setLaborCostPerSqFoot(newLaborCostPerSqFoot);
        
        double newMaterialCost = calc.calculateMaterialCost(newArea, newMaterialCostPerSqFoot);
        targetOrder.setMaterialCost(newMaterialCost);
        
        double newLaborCost = calc.calculateLaborCost(newArea, newLaborCostPerSqFoot);
        targetOrder.setLaborCost(newLaborCost);
        
        double newTax = calc.calculateTax(newMaterialCost, newLaborCost, newTaxRate);
        targetOrder.setTax(newTax);

        double newTotal = calc.calculateTotalCost(newMaterialCost, newLaborCost, newTax);
        targetOrder.setTotalCost(newTotal);

        return newOrder;
    }

}
