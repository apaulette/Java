package com.sg.flooringmastery.ops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */

public class Calculations {
    
    public double calculateMaterialCost(double area, double materialCostPerSqFoot) {
        double materialCost = Math.round(area * materialCostPerSqFoot * 100D) / 100D;
        return materialCost;
    }

    public double calculateLaborCost(double area, double laborCostPerSqFoot) {
        double laborCost = Math.round(area * laborCostPerSqFoot * 100D) / 100D;
        return laborCost;
    }

    public double calculateTax(double materialCost, double laborCost, double taxRate) {
        double tax = Math.round(((materialCost + laborCost) * (taxRate) / 100) * 100D) / 100D;
        return tax;
    }

    public double calculateTotalCost(double materialCost, double laborCost, double tax) {
        double totalCost = Math.round((materialCost + laborCost + tax) * 100D) / 100D;
        return totalCost;
    }
    
}
