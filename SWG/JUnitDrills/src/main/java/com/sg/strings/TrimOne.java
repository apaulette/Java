package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TrimOne {

    public String trimOne(String str) {
        String result = str.substring(1, str.length() - 1);
        return result;
    }

}