package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MultipleEndings {

    public String multipleEndings(String str) {
        String result = str.substring(str.length()-2) 
                + str.substring(str.length()-2) 
                + str.substring(str.length()-2);
        return result;
    }

}
