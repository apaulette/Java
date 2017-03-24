package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LongInMiddle {

    public String longInMiddle(String a, String b) {
        String result;
        
        if (a.length() > b.length()) {
            result = b + a + b;
        } else {
            result = a + b + a;
        }
        
        return result;
    }

}
