package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FrontAgain {
    
    public boolean frontAgain(String str) {
        boolean match = false;

        if (str.length() == 2) {
            match = true;
        } else if (str.length() > 2 && str.substring(0, 2).equals(str.substring(str.length() - 2))) {
            match = true;
        }
        return match;
    }

}
