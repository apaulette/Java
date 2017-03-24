package com.sg.strings;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class InsertWord {
    
    public String insertWord(String container, String word) {
        String result = container.substring(0, 2) + word + container.substring(2);
        return result;
    }

}
