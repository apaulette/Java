package com.sg.strings.test;

import com.sg.strings.HasBad;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class HasBadTest {
    
HasBad testMe = new HasBad();
    
    public HasBadTest() {
    }
    
    //    Given a String, return true if "bad" appears starting at 
    //    index 0 or 1 in the String, such as with "badxxx" or "xbadxx" 
    //    but not "xxbadxx". The String may be any length, including 0.

    
    @Test
    public void testHasBad() {
        //    hasBad("badxx") -> true
        assertTrue(testMe.hasBad("badxx"));
        //    hasBad("xbadxx") -> true
        assertTrue(testMe.hasBad("xbadxx"));
        //    hasBad("xxbadxx") -> false
        assertFalse(testMe.hasBad("xxbadxx"));
        //    hasBad("xbad") -> false
        assertTrue(testMe.hasBad("xbad"));
    }
    
}
