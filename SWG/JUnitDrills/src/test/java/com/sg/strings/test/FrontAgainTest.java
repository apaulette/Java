package com.sg.strings.test;

import com.sg.strings.FrontAgain;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FrontAgainTest {

    FrontAgain testMe = new FrontAgain();
    
    public FrontAgainTest () {
    }
    
    // Given a String, return true if the first 2 chars in the 
    // String also appear at the end of the String, such as with "edited".
    
    @Test
    public void testFrontAgain() {
        // frontAgain("edited") -> true
        assertTrue(testMe.frontAgain("edited"));
        // frontAgain("edit") -> false
        assertFalse(testMe.frontAgain("edit"));
        // frontAgain("ed") -> true
        assertTrue(testMe.frontAgain("ed"));
    }

}