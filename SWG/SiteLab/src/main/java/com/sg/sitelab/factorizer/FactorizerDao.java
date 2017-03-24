package com.sg.sitelab.factorizer;

import java.util.ArrayList;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public interface FactorizerDao {
    
    public void calculateFactors(ArrayList<Integer> factors, int chosenNumber);
    public String evaluateIfPerfect(ArrayList<Integer> factors, int chosenNumber);
    public String evaluateIfPrime(ArrayList<Integer> factors, int chosenNumber);
    
}
