package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class OrderDaoFileImpl implements OrderDao {

//    private Scanner sc = new Scanner(System.in);
    private final String FILE_PATH;
    private final String FILE_PRE;
    private final String FILE_EXT;
    private ArrayList<Order> allOrders;
    private final String DELIM = "\t";


    public OrderDaoFileImpl() {
        FILE_PATH = "data/orders/";
        FILE_PRE = "Orders_";
        FILE_EXT = ".txt";
        allOrders = new ArrayList<>();
    }

    @Override
    public void addOrder(Order newOrder) {
        allOrders.add(allOrders.size(), newOrder);
    }

    @Override
    public ArrayList<Order> retrieveAllOrders() {
        return allOrders;
    }

    @Override
    public void updateOrder(Order targetOrder, Order updatedOrder) {
        allOrders.set(allOrders.indexOf(targetOrder), updatedOrder);
    }

    @Override
    public Order findOrder(int orderNumber) {
        Order targetOrder = null;
        for (Order order : allOrders) {
            if (order.getOrderNumber() == orderNumber) {
                targetOrder = order;
            }
        }
        return targetOrder;
    }
    
    @Override
    public int generateOrderNumber() {
        int maxOrderNumber = 0;
        if (allOrders.isEmpty()) {
            maxOrderNumber = 1;
        } else {
            for (int i = 0; i < allOrders.size(); i++) {
                if (allOrders.get(i).getOrderNumber() > maxOrderNumber) {
                    maxOrderNumber = allOrders.get(i).getOrderNumber();
                }
            }
            maxOrderNumber += 1;
        }
        return maxOrderNumber;
    }
    
    @Override
    public ArrayList<String> retrieveAllOrderNumbers() {
        ArrayList<String> allOrderNumbers = new ArrayList<String>();
        for (Order order : allOrders) {
            allOrderNumbers.add(String.valueOf(order.getOrderNumber()));
        }
        return allOrderNumbers;
    }

    @Override
    public void removeOrder(Order targetOrder) {
        allOrders.remove(targetOrder);
    }
    
    @Override
    public Boolean checkForExistingOrderNumber(String requestedOrderNumber) {
        boolean existingOrderNumber = false;
        for (Order order : allOrders) {
            if (order.getOrderNumber() == Integer.parseInt(requestedOrderNumber)) {
                existingOrderNumber = true;
            }
        }
        return existingOrderNumber;
    }

    @Override
    public Boolean checkForExistingFile(String date) {
        File directory = new File(FILE_PATH);
        File[] fileList = directory.listFiles();
        boolean existingFile = false;
        for (File file : fileList) {
            if (file.getName().contains(date)) {
                existingFile = true;
            }
        }
        return existingFile;
    }

    @Override
    public void loadData(String date) {

        try (Scanner readFileIn = new Scanner(new BufferedReader(new FileReader(FILE_PATH + FILE_PRE + date + FILE_EXT)))) {
            String currentLine;
            String[] field;

            while (readFileIn.hasNextLine()) {
                currentLine = readFileIn.nextLine();
                field = currentLine.split(DELIM);

                Order newOrder = new Order();
                newOrder.setOrderNumber(Integer.parseInt(field[0]));
                newOrder.setCustomerName(field[1]);
                newOrder.setState(field[2]);
                newOrder.setTaxRate(Double.parseDouble(field[3]));
                newOrder.setProductType(field[4]);
                newOrder.setArea(Double.parseDouble(field[5]));
                newOrder.setMaterialCostPerSqFoot(Double.parseDouble(field[6]));
                newOrder.setLaborCostPerSqFoot(Double.parseDouble(field[7]));
                newOrder.setMaterialCost(Double.parseDouble(field[8]));
                newOrder.setLaborCost(Double.parseDouble(field[9]));
                newOrder.setTax(Double.parseDouble(field[10]));
                newOrder.setTotalCost(Double.parseDouble(field[11]));

                allOrders.add(newOrder);
            }
            readFileIn.close();
        } catch (FileNotFoundException fnf) {
            // Do nothing for now
        }
    }

    @Override
    public void saveData(String date) {
        try {
            writeDataToFile(date);
        } catch (IOException ioe) {
            System.out.println("\n\u25B3 ERROR: Not able to save file for " + date + ". "
                    + "Returning to main menu.");
        }
    }

    private void writeDataToFile(String date) throws IOException {

        StringBuilder sb = new StringBuilder();
        for (Order order : allOrders) {
            sb.append(order.getOrderNumber());
            sb.append(DELIM);
            sb.append(order.getCustomerName());
            sb.append(DELIM);
            sb.append(order.getState());
            sb.append(DELIM);
            sb.append(order.getTaxRate());
            sb.append(DELIM);
            sb.append(order.getProductType());
            sb.append(DELIM);
            sb.append(order.getArea());
            sb.append(DELIM);
            sb.append(order.getMaterialCostPerSqFoot());
            sb.append(DELIM);
            sb.append(order.getLaborCostPerSqFoot());
            sb.append(DELIM);
            sb.append(order.getMaterialCost());
            sb.append(DELIM);
            sb.append(order.getLaborCost());
            sb.append(DELIM);
            sb.append(order.getTax());
            sb.append(DELIM);
            sb.append(order.getTotalCost());
            sb.append("\n");
        }
        String allOrderString = sb.toString();
        
        try {
            File targetFile = new File(FILE_PATH + FILE_PRE + date + FILE_EXT);            
            // If file doesn't exist, then create it
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            // If file.exists(), append file
            FileWriter fileWrite = new FileWriter(targetFile, true);
            BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
            bufferWrite.append(allOrderString);
            bufferWrite.close();
        } catch (IOException e) {
            System.out.println("\n\u25B3 ERROR: Not able to write file for " + date + ". "
                    + "Returning to main menu.");
        }       
    }

}