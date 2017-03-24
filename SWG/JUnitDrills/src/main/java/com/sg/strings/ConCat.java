package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ConCat {
    
    public String conCat(String a, String b) {
        String result = "";
        if (a.length() >= 1 && b.length() > 1 && a.substring(a.length()-1).equals(b.substring(0, 1))) {
            result = a.concat(b.substring(1));
        } else if (a.length() >= 1 && b.length() == 1 && a.substring(a.length()-1).equals(b)) {
            result = a;
        } else {
            result = a.concat(b);
        }
        return result;
    }
    
}