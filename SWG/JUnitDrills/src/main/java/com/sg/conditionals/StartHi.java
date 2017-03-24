package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StartHi {
    
    public boolean startHi(String str) {
        boolean meetsCriteria = false;
        
        if (str.equals("hi") || str.length() > 2 && str.substring(0, 3).equals("hi ")) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }    
}