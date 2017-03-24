package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RotateLeft2 {
    
    public String rotateLeft2(String str) {
        
        String result;
        String x = str.substring(0, 2), y = str.substring(2);
        
        if (str.length() > 2) {
            result = y + x;
        } else {
            result = str;
        }
        
        return result;
    }

}