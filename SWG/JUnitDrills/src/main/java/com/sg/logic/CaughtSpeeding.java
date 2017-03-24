package com.sg.logic;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CaughtSpeeding {

    
    public int caughtSpeeding(int speed, boolean isBirthday) {
        
        int ticket = 0;
        
        if (speed <= 60 || (speed <= 65 && isBirthday)) {
            ticket = 0;
        } else if ((speed > 60 && speed<= 80) || 
                (speed > 65 && speed<= 85 && isBirthday)) {
            ticket = 1;
        } else if (speed >= 81 || (speed >= 86 && isBirthday)) {
            ticket = 2;
        }
        
        return ticket;
    }

}
