/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.tipcalculator;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TipCalculations {
    
    public double calculateTipAmount(double checkAmount, double tipPercent) {
        double tipAmount = checkAmount * (tipPercent/100);
        return tipAmount;
    }
    
    public double calculateTotalAmount(double checkAmount, double tipAmount) {
        double totalAmount = checkAmount + tipAmount;
        return totalAmount;
    }
    
}
