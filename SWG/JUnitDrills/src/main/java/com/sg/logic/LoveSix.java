package com.sg.logic;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LoveSix {

  
    public boolean loveSix(int a, int b) {
        
        boolean isGreatNumber;
        
        if (a == 6 || b == 6 || (a + b == 6) || (a-b == 6)) {
            isGreatNumber = true;
        } else {
            isGreatNumber = false;
        }
        
        return isGreatNumber;

    }

}