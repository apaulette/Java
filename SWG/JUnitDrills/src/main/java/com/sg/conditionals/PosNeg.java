package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class PosNeg {

    public boolean posNeg(int a, int b, boolean negative) {
        
        boolean result = false;
        
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            result = true;
        } else if (negative && a < 0 && b < 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}
