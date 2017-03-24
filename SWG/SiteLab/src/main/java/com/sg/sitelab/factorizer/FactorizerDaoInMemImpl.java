/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.factorizer;

import java.util.ArrayList;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FactorizerDaoInMemImpl implements FactorizerDao {
    
    @Override
    public void calculateFactors(ArrayList<Integer> factors, int chosenNumber) {
        int divisor = 1;
        while (divisor < chosenNumber) {
            if (chosenNumber % divisor == 0) {
                factors.add(divisor);
                divisor++;
            } else {
                divisor++;
            }
        }        
    }
    
    @Override
    public String evaluateIfPerfect(ArrayList<Integer> factors, int chosenNumber) {
        int sumOfFactors= 0;
        for (int i=0 ; i<factors.size(); i++) {
            sumOfFactors += factors.get(i);
        }
        
        String perfectEvaluation = "";
        if (sumOfFactors == chosenNumber) {
            perfectEvaluation = "is a Perfect Number.";
        } else {
            perfectEvaluation = "is not a Perfect Number.";
        }
        return perfectEvaluation;
    }
    
    @Override
    public String evaluateIfPrime(ArrayList<Integer> factors, int chosenNumber) {
        String primeEvaluation = "";
        if (factors.size() < 2) {
            factors.add(chosenNumber);
            primeEvaluation = "is a Prime Number.";
        } else {
            primeEvaluation = "is not a Prime Number.";
        }
        return primeEvaluation;
    }
    

}
