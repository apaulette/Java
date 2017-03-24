package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SwapLast {

    public String swapLast(String str) {
        String result = "";
        String x = "";
        String y = "";
        String z = "";
        
        if (str.length() < 2){
            result = str;
        } else if (str.length() == 2 ) {
            z = str.substring(0, 1);
            y = str.substring(1);
            result = y.concat(z);
        } else if (str.length() > 2) {
            x = str.substring(0, str.length()-2);
            z = str.substring(str.length()-2, str.length()-1);
            y = str.substring(str.length()-1);
            result = x.concat(y).concat(z);
        }
        return result;
    }

}
