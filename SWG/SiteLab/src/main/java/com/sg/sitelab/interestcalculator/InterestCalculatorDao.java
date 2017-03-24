/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.interestcalculator;

import java.util.ArrayList;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public interface InterestCalculatorDao {
    
    public ArrayList<YearCalculation> returnCalcResults();
    public double selectCompoundFrequency(String compoundFrequencyString);

}
