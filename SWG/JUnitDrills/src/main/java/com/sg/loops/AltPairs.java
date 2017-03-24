package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AltPairs {
    
    public String altPairs(String str) {
        String result = "";
        String[] strArray = str.split("");
        
        for (int i = 0 ; i < strArray.length; i++) {
            if (i % 4 == 0 || i % 4 == 1) {
                result = result.concat(strArray[i]);
            }
        }

        return result;
    }    
    
}