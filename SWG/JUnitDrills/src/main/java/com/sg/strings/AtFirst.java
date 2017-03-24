package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AtFirst {
    
    public String atFirst(String str) {
        String result="";
        if (str.length() < 2) {
            result = str.concat("@");
        } else if (str.length() == 2) {
            result = str;
        } else {
            result = str.substring(0,2);
        }
        return result;
    }    
}
