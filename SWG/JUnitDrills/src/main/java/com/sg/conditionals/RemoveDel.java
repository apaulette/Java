package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RemoveDel {
    
    public String removeDel(String str) {
        String result = str;
        if (str.substring(1, 4).equals("del")) {
            result = str.substring(0, 1).concat(str.substring(4));
        }
        return result;
    }
    
}