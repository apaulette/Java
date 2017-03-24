package com.sg.logic.test;

import com.sg.logic.AlarmClock;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AlarmClockTest {
    
    AlarmClock testIt = new AlarmClock();

    public AlarmClockTest() {
    }
 
    //    Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...
    //    6=Sat, and a booleanean indicating if we are on vacation, 
    //    return a String of the form "7:00" indicating when the 
    //    alarm clock should ring. Weekdays, the alarm should be 
    //    "7:00" and on the weekend it should be "10:00". Unless we 
    //    are on vacation -- then on weekdays it should be "10:00" 
    //    and weekends it should be "off". 
    
    @Test
    public void testalarmClock() {
        
        // alarmClock(1, false) → "7:00"
        assertEquals("7:00", testIt.alarmClock(1, false));
        
        // alarmClock(5, false) → "7:00"
        assertEquals("7:00", testIt.alarmClock(5, false));

        // alarmClock(0, false) → "10:00"
        assertEquals("10:00", testIt.alarmClock(0, false));

        // alarmClock(7, true) → "10:00"
        assertEquals("off", testIt.alarmClock(7, true));

    }    
    
}
