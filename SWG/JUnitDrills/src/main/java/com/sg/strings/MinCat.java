package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MinCat {

    public String minCat(String a, String b) {
        String result = "";
        
        if (a.length() == b.length()) {
            result = a.concat(b);
        } else if (a.length() < b.length()) {
            result = a.concat(b.substring(b.length() - a.length()));
        } else if (a.length() > b.length()) {
            result = a.substring(a.length() - b.length()).concat(b);
        }
        
        return result;
    }

}
