/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.interestcalculator;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class InterestCalculations {
    
    public double calculateYearEndingBalance(double investmentBalance,
            double compoundFrequency, double interestRate) {
        for (int i = 0; i < compoundFrequency; i++) {
            investmentBalance = investmentBalance * (1 + (interestRate / compoundFrequency) / 100);
        }
        investmentBalance = Math.round(investmentBalance * 100D) / 100D;
        return investmentBalance;
    }
    
    public double calculateYearInterestEarned(double yearEndingBalance, 
            double yearBeginningBalance) {
        double result = yearEndingBalance - yearBeginningBalance; 
        return result;
    }
    
}
