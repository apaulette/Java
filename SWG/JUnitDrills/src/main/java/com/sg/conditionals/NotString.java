package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class NotString {
    
    public String notString(String s) {
        
        String result;
        
        if (s.length() >=3 && s.substring(0, 3).equalsIgnoreCase("not")) {
            result = s;
        } else {
            result = "not " + s;
        }
        return result;
    }
}