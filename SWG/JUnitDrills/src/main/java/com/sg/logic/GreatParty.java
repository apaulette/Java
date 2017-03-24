package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class GreatParty {

    public boolean greatParty(int cigars, boolean isWeekend) {
       
        boolean isGreatParty = false;
        
        if ((cigars >= 40 && cigars <= 60) && !isWeekend) {
            isGreatParty = true;
        } else if (isWeekend && cigars >= 40) {
            isGreatParty = true;
        }
        
        return isGreatParty;

    }

}

