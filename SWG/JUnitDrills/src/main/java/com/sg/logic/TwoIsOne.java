package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TwoIsOne {
    
    public boolean twoIsOne(int a, int b, int c) {
        boolean possible = false;
        if ((a + b == c) || (b + c == a) || (a + c == b)) {
            possible = true;
        }
        return possible;
    }
    
}