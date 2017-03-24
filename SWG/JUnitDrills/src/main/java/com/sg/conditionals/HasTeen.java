package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class HasTeen {
    
    public boolean hasTeen(int a, int b, int c) {
        boolean meetsCriteria = false;
        
        if(a >= 13 && a <= 19 || b >= 13 && b <= 19 || c >= 13 && c <= 19) {
            meetsCriteria = true;
        }        
        return meetsCriteria;
    }
    
}