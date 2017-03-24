package com.sg.flooringmastery.dto;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Product {
    
    private String productType;
    private double materialCostPerSqFoot;
    private double laborCostPerSqFoot;

    public Product() {
    }
    
    public Product(String productType, double materialCostPerSqFoot, double laborCostPerSqFoot) {
        this.productType = productType;
        this.materialCostPerSqFoot = materialCostPerSqFoot;
        this.laborCostPerSqFoot = laborCostPerSqFoot;
    }

    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
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
    
    @Override
    public String toString() {
        String output = this.getProductType();
        return output;
    }
    
    
    
}
