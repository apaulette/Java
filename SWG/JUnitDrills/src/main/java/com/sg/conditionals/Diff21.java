package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Diff21 {

    public int diff21(int n) { 
        
        int result;
        
        if (n > 21) {
            result = Math.abs(n - 21) * 2;
        } else {
            result = Math.abs(n - 21);
        }
        return result;
    }

}
