package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MissingChar {
    
    public String missingChar(String str, int n) {
        
        String result = "";
        
        if (n > 0) {
            result = str.substring(0, n) + str.substring(n + 1);
        } else if (n == 0) {
            result = str.substring(n + 1);
        }
        return result;
    }

}
