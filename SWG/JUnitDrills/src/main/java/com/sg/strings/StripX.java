package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StripX {

    // Given a String, if the first or last chars are 'x', return 
    // the String without those 'x' chars, and otherwise return 
    // the String unchanged. 
    
    // stripX("xHix") -> "Hi"
    // stripX("xHi") -> "Hi"
    // stripX("Hxix") -> "Hxi"
    
    public String stripX(String str) {
        String result = str;
        
        if (str.substring(0, 1).equals("x") && str.substring(str.length()-1).equals("x")) {
            result = str.substring(1, str.length()-1);
        }
        if (str.substring(0, 1).equals("x") && !str.substring(str.length()-1).equals("x")) {
            result = str.substring(1);
        }
        if (!str.substring(0, 1).equals("x") && str.substring(str.length()-1).equals("x")) {
            result = str.substring(0, str.length() - 1);
        }

        return result;
    }

}
