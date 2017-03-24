package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Mod20 {
    
    public boolean mod20(int n) {
        boolean meetsCriteria = false;
        if (n % 20 == 1 || n % 20 == 2) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }
    
}
