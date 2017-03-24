package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StringX {
    
    public String stringX(String str) {
        String result = str.substring(0, 1).concat(str.substring(1, str.length()-1)
                .replace("x", "")).concat(str.substring(str.length()-1));
        return result;
    }
    
}