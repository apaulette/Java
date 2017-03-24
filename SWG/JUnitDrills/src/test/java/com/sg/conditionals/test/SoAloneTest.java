package com.sg.conditionals.test;

import com.sg.conditionals.SoAlone;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SoAloneTest {

    SoAlone testMe = new SoAlone();

    public SoAloneTest() {
    }

    // We'll say that a number is "teen" if it is in the range 13..19 
    // inclusive. Given 2 int values, return true if one or the other 
    // is teen, but not both. 

    @Test
    public void testSoAlone() {
        // soAlone(13, 99) -> true
        assertTrue(testMe.soAlone(13, 99));
        // soAlone(21, 19) -> true
        assertTrue(testMe.soAlone(21, 19));
        // soAlone(13, 13) -> false
        assertFalse(testMe.soAlone(13, 13));
    }

}