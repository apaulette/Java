package com.sg.logic.test;

import com.sg.logic.CaughtSpeeding;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CaughtSpeedingTest {

    CaughtSpeeding testIt = new CaughtSpeeding();

    public CaughtSpeedingTest() {
    }

    //    You are driving a little too fast, and a police officer stops you. 
    //    Write code to compute the result, encoded as an int value: 
    //    0=no ticket, 1=small ticket, 2=big ticket. If speed is 60 or less, 
    //    the result is 0. If speed is between 61 and 80 inclusive, the result 
    //    is 1. If speed is 81 or more, the result is 2. Unless it is your 
    //    birthday -- on that day, your speed can be 5 higher in all cases. 
    
    @Test
    public void testCaughtSpeeding() {

        //    caughtSpeeding(60, false) → 0
        assertEquals(0, testIt.caughtSpeeding(60, false));

        //    caughtSpeeding(65, false) → 1
        assertEquals(1, testIt.caughtSpeeding(65, false));

        //    caughtSpeeding(65, true) → 0
        assertEquals(0, testIt.caughtSpeeding(65, true));

    }

}
