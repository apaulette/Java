package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class PlayOutside {

    public boolean playOutside(int temp, boolean isSummer) {
        
        boolean playOutside;
        
        if ((temp >= 60 && temp <= 90) && !isSummer) {
            playOutside = true;
        } else if (temp >= 60 && temp <= 100 && isSummer) {
            playOutside = true;
        } else {
            playOutside = false;
        }
        return playOutside;
    }

}