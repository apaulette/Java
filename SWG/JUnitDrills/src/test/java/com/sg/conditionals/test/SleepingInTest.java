package com.sg.conditionals.test;

import com.sg.conditionals.SleepingIn;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SleepingInTest {
    
    SleepingIn testMe = new SleepingIn();
    
    public SleepingInTest() {
    }
    // The parameter weekday is true if it is a weekday, and the parameter 
    // vacation is true if we are on vacation. We sleep in if it is not a 
    // weekday or we're on vacation. Return true if we sleep in. 
    
    @Test
    public void test() {
        
        // canSleepIn(false, false) -> true
        assertTrue(testMe.canSleepIn(false, false));

        // canSleepIn(true, false) -> false
        assertFalse(testMe.canSleepIn(true, false));

        // canSleepIn(false, true) -> true
        assertTrue(testMe.canSleepIn(false, true));
        
    }

}