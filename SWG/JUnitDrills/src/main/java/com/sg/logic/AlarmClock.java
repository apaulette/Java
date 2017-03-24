package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AlarmClock {
    
    
    public String alarmClock(int day, boolean vacation) {
        
        String shouldRing = null;
        
        if (day >= 1 && day <= 5 && !vacation) {
            shouldRing = "7:00";
        } else if ((day == 0 || day == 7 && !vacation) 
                || ((day >= 1 && day <= 5 && vacation))) {
            shouldRing = "10:00";
        } else if ((day == 0 || day == 7) && vacation) {
            shouldRing = "off";
        }
        
        return shouldRing;
    }      
    
}