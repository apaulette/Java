package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MiddleTwo {

    public String middleTwo(String str) {
        
        String result;
        int n = str.length();
        
        if (n >= 4) {
            result = str.substring(n/2 - 1, n/2 + 1);
        } else {
            result = str;
        }
        
        return result;
    }

}