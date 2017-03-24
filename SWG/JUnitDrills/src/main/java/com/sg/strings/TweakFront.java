package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TweakFront {
    
    public String tweakFront(String str) {
        String result = "";
        
        if (str.length() == 1 && str.equals("a")) {
            result = str;
        }
        
        if (str.length() == 2 && str.substring(0, 1).equals("a") && !str.substring(1).equals("b")) {
            result = str.substring(0, 1);
        } else if (str.length() == 2 && !str.substring(0, 1).equals("a") && str.substring(1).equals("b")) {
            result = str.substring(1);
        } else if (str.length() == 2 && str.substring(0, 1).equals("a") && str.substring(1).equals("b")) {
            result = str;
        }
        
        if (str.length() > 2 && str.substring(0, 1).equals("a") && str.substring(1, 2).equals("b")) {
            result = str;
        } else if (str.length() > 2 && !str.substring(0, 1).equals("a") && !str.substring(1, 2).equals("b")) {
            result = str.substring(2);
        } else if (str.length() > 2 && str.substring(0, 1).equals("a") && !str.substring(1, 2).equals("b")) {
            result = str.substring(0, 1).concat(str.substring(2));
        } else if (str.length() > 2 && !str.substring(0, 1).equals("a") && str.substring(1, 2).equals("b")) {
            result = str.substring(1);
        }
            
        return result;
    }
    
}
