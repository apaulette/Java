package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Makes10 {

    public boolean makes10(int a, int b) {
        
        boolean result = false;
        
        if ((a + b == 10) || a == 10 || b == 10) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}
