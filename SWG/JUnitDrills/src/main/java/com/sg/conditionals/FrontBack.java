package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FrontBack {

    public String frontBack(String str) {
        
        String result = "", x = "", y = "", z = "";
        int n = str.length();
        
        if (n == 1) {
            result = str;
        } else if (n == 2) {
            x = str.substring(0, 1);
            y = str.substring(1);
            result = y + x;
        } else {
            x = str.substring(0, 1);
            y = str.substring(1, n - 1);
            z = str.substring(n - 1);
            result = z + y + x;
        }
        
        return result;
    }

}