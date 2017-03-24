package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SumDouble {

    public int sumDouble(int a, int b) {
        
        int result;
        
        if (a == b) {
            result = (a + b) * 2;
        } else {
            result = a + b;
        }
        
        return result;
    }

}
