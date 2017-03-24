package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StartOz {
    
    public String startOz(String str) {
        String result = "";
        
        if (str.substring(0, 1).equals("o") && str.substring(1, 2).equals("z")) {
            result = "oz";
        }
        if (str.substring(0, 1).equals("o") && !str.substring(1, 2).equals("z")) {
            result = "o";
        }
        if (!str.substring(0, 1).equals("o") && str.substring(1, 2).equals("z")) {
            result = "z";
        }
        
        return result;
    }    
}
