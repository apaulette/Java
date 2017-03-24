package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SkipSum {
    
    
    public int skipSum(int a, int b) {
        int sum;
        
        if (a + b >= 10 && a + b < 20) {
            sum = 20;
        } else {
            sum = a + b;
        }
        
        return sum;
    }    
}
