package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class EveryOther {


    public String everyOther(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i += 2) {
            if (str.length() > 2) {
                if (i < str.length()) {
                    result = result.concat(str.substring(i, i + 1));
                }
                if (i == str.length()) {
                    result = result.concat(str.substring(i));
                }
            } else {
                result = str.substring(0, 1);
            }
        }
        return result;
    }

}
