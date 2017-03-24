package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ParrotTrouble {
    
    public boolean parrotTrouble(boolean isTalking, int hour) {
        
        boolean parrotTrouble = false;
        
        if (isTalking && (hour < 7 || hour > 20)) {
            parrotTrouble = true;
        } else {
            parrotTrouble = false;
        }
        return parrotTrouble;
    }

}
