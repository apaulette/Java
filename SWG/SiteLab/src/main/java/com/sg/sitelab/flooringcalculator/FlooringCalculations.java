/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.flooringcalculator;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FlooringCalculations {
    
    double dimensionToInches(String feet, String additionalInches) {
        double result = (Double.parseDouble(feet) * 12) + Double.parseDouble(additionalInches);
        return result;
    }

    double calculateArea(double width, double length) {
        double result = (width * length) / 144;
        return result;
    }

    double calculateCostForArea(double costPerSqFt, double area) {
        double result = costPerSqFt * area;
        return result;
    }

    String calculateInstallationTime(double area) {
        int hours = (int) area / 20;
        int minutes = Math.round((float) (area%20)/20 * 60);
        String installationTime = "";
        if (minutes == 0) {
            installationTime = hours + " hours";
        } else {
            installationTime = hours + " hours, " + minutes + " minutes";
        }
        return installationTime;
    }

    int calculateBilledIncrements(double area) {
        int increments = (int) Math.ceil(area / 5);
        return increments;
    }

    double calculateLaborCosts(int billedIncrements) {
        double laborCosts = billedIncrements * 21.5;
        return laborCosts;
    }

}