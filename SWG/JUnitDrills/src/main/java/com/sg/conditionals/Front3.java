package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Front3 {

    public String front3(String str) {
        
        String result;
        
        if (str.length() <= 3) {
            result = str + str + str;
        } else {
            result = str.substring(0, 3) + str.substring(0, 3) + str.substring(0, 3);
        }
        
        return result;
    }

}