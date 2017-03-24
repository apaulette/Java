package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SleepingIn {
    // The parameter weekday is true if it is a weekday, and the parameter 
    // vacation is true if we are on vacation. We sleep in if it is not a 
    // weekday or we're on vacation. Return true if we sleep in. 

    public boolean canSleepIn(boolean isWeekday, boolean isVacation) {
        
        boolean canSleepIn = false;
        
        if (!isWeekday || isVacation) {
            canSleepIn = true;
        } else {
            canSleepIn = false;
        }
        
        return canSleepIn;
    }

}
