package com.sg.flooringmastery.dto;

import java.util.ArrayList;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Tax {

    private String state;
    private double taxRate;
    
    public Tax() {
    }

    public Tax(String state, double taxRate) {
        this.state = state;
        this.taxRate = taxRate;
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



}
