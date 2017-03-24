package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class InOrderEqual {
    
    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        boolean meetsCriteria = false;
        if ((a < b && b < c && !equalOk) || ((a == b || b == c) && a <= c && equalOk)) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }    
}
