package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class EEEEEEE {
    
    public boolean gotE(String str) {
        boolean meetsCriteria = false;
        int eCount = 0;
        String[] strChars = str.split("");
        
        for (String strChar : strChars) {
            if (strChar.equals("e")) {
                eCount += 1;
            }
        }
        
        if (eCount >= 1 && eCount <= 3) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }
    
}