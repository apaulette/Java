package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class DoNotYak {
    
    public String doNotYak(String str) {
        String result = "";
        
        for (int i = 0 ; i <= str.length()-3; i++) {
            if (i == str.length()-3) {
                if (str.substring(i, i+1).equals("y") && str.substring(i+2).equals("k")) {
                    result = str.replace(str.substring(i), "");
                }
            } else {
                if (str.substring(i, i+1).equals("y") && str.substring(i+2, i+3).equals("k")) {
                    result = str.replace(str.substring(i, i+3), "");
                }
            }
        }
        return result;
    }
    
}