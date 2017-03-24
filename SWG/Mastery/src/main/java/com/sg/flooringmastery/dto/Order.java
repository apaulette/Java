package com.sg.flooringmastery.dto;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Order {

    private int orderNumber;
    private String customerName;
    private String state;
    private double taxRate;
    private String productType;
    private double area;
    private double materialCostPerSqFoot;
    private double laborCostPerSqFoot;
    private double materialCost;
    private double laborCost;
    private double tax;
    private double totalCost;

    public Order() {
    }
    
    public Order(int orderNumber, String customerName, String state, 
            double taxRate, String productType, double area, 
            double materialCostPerSqFoot, double laborCostPerSqFoot, 
            double materialCost, double laborCost, double tax, double totalCost) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.state = state;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        this.materialCostPerSqFoot = materialCostPerSqFoot;
        this.laborCostPerSqFoot = laborCostPerSqFoot;
        this.materialCost = materialCost;
        this.laborCost = laborCost;
        this.tax = tax;
        this.totalCost = totalCost;
    }
    
    public Order(Order copyingFrom) {
        this.orderNumber = copyingFrom.orderNumber;
        this.customerName = copyingFrom.customerName;
        this.state = copyingFrom.state;
        this.taxRate = copyingFrom.taxRate;
        this.productType = copyingFrom.productType;
        this.area = copyingFrom.area;
        this.materialCostPerSqFoot = copyingFrom.materialCostPerSqFoot;
        this.laborCostPerSqFoot = copyingFrom.laborCostPerSqFoot;
        this.materialCost = copyingFrom.materialCost;
        this.laborCost = copyingFrom.laborCost;
        this.tax = copyingFrom.tax;
        this.totalCost = copyingFrom.totalCost;
    }
    
    

    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }

    public double getMaterialCostPerSqFoot() {
        return materialCostPerSqFoot;
    }
    public void setMaterialCostPerSqFoot(double materialCostPerSqFoot) {
        this.materialCostPerSqFoot = materialCostPerSqFoot;
    }

    public double getLaborCostPerSqFoot() {
        return laborCostPerSqFoot;
    }
    public void setLaborCostPerSqFoot(double laborCostPerSqFoot) {
        this.laborCostPerSqFoot = laborCostPerSqFoot;
    }

    public double getMaterialCost() {
        return materialCost;
    }
    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    public double getLaborCost() {
        return laborCost;
    }
    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        String string = "\n========================================"
                + "\n\u25FE ORDER NUMBER: " + this.orderNumber
                + "\n  --------------------------------------"
                + "\n  - Customer Name:      " + this.customerName
                + "\n  - State:              " + this.state
                + "\n  - State Sales Tax:    " + this.taxRate + "%"
                + "\n  --------------------------------------"
                + "\n  - Product:            " + this.productType
                + "\n  - Area:               " + this.area + " ft\u00B2"
                + "\n  - Material Cost/ft\u00B2:  $" + String.format("%.2f", this.materialCostPerSqFoot)
                + "\n  - Labor Cost/ft\u00B2:     $" + String.format("%.2f", this.laborCostPerSqFoot)
                + "\n  --------------------------------------"
                + "\n  - Material Cost:      $" + String.format("%.2f", this.materialCost)
                + "\n  - Labor Cost:         $" + String.format("%.2f", this.laborCost)
                + "\n  - Tax:                $" + String.format("%.2f", this.tax)
                + "\n  - Total Cost:         $" + String.format("%.2f", this.totalCost);
        return string;
    }
    
    public String toStringSummary() {
        String string = "\n========================================"
                + "\n\u25FE ORDER SUMMARY:        " + this.orderNumber
                + "\n  - Customer Name:      " + this.customerName
                + "\n  - Total Cost:         $" + String.format("%.2f", this.totalCost);        
        return string;
    }
    
}