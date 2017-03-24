package com.sg.sitelab.interestcalculator;

import java.util.ArrayList;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class InterestCalculatorDaoInMemImpl implements InterestCalculatorDao {
    
    private ArrayList<YearCalculation> calcResults;
    
    public InterestCalculatorDaoInMemImpl(){
        calcResults = new ArrayList<>();
    }
    
    @Override
    public ArrayList<YearCalculation> returnCalcResults() {
        return calcResults;
    }
    
    @Override
    public double selectCompoundFrequency(String compoundFrequencyString){
        double compoundFrequency = 0;
        switch (compoundFrequencyString) {
            case "annually":
                compoundFrequency = 1;
                break;
            case "semiannually":
                compoundFrequency = 2;
                break;
            case "quarterly":
                compoundFrequency = 4;
                break;
            case "monthly":
                compoundFrequency = 12;
                break;
            case "daily":
                compoundFrequency = 365;
                break;
        }
        return compoundFrequency;
    }
    
}
