package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TakeOne {

    public String takeOne(String str, boolean fromFront) {
        
        String result;
        
        if (fromFront == true) {
            result = str.substring(0, 1);
        } else {
            result = str.substring(str.length() - 1);
        }
        
        return result;
    }

}