package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MischeviousChildren {

    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
        
        boolean areWeInTrouble = false;
        
         if ((aSmile && bSmile) || (!aSmile && !bSmile)) {
            areWeInTrouble = true;
        } else {
            areWeInTrouble = false;
        }
        
        return areWeInTrouble;

    }

}
