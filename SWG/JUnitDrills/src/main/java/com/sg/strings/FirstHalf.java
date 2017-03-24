package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FirstHalf {

    public String firstHalf(String str) {
        String result = str.substring(0, str.length()/2);
        return result;
    }

}
