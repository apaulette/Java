package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class NearHundred {

    public boolean nearHundred(int n) {
        
        boolean result = false;
        
        if ((n >= 90 && n <= 110) || (n >= 190 && n <= 210)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

}