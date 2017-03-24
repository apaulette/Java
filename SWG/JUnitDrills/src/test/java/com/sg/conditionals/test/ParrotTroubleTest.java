package com.sg.conditionals.test;

import com.sg.conditionals.ParrotTrouble;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ParrotTroubleTest {

    ParrotTrouble testParrotTrouble = new ParrotTrouble();

    public ParrotTroubleTest() {
    }
    // We have a loud talking parrot. The "hour" parameter is the 
    // current hour time in the range 0..23. We are in trouble if
    // the parrot is talking and the hour is before 7 or after 20. 
    // Return true if we are in trouble. 

    @Test
    public void test() {
        
        // parrotTrouble(true, 6) -> true
        assertTrue(testParrotTrouble.parrotTrouble(true, 6));

        // parrotTrouble(true, 7) -> false
        assertFalse(testParrotTrouble.parrotTrouble(true, 7));

        // parrotTrouble(false, 6) -> false
        assertFalse(testParrotTrouble.parrotTrouble(false, 6));
        
    }

}