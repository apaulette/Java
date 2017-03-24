package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RotateRight {
    
    public String rotateRight2(String str) {
        String result;
        int n = str.length();
        String x = str.substring(0, n - 2), y = str.substring(n - 2);
        
        if (str.length() > 2) {
            result = y + x;
        } else {
            result = str;
        }
        
        return result;
    }

}