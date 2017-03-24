package com.sg.loops;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FrontTimes {

    public String frontTimes(String str, int n) {
        String output = "";
        for (int i = 0 ; i < n ; i++) {
            if (str.length() > 3) {
                output = output.concat(str.substring(0, 3));
            } else {
                output = output.concat(str.substring(0));
            }
        }
        return output;
    }

}