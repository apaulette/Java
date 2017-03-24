package com.sg.conditionals.test;

import com.sg.conditionals.StartHi;
import org.junit.Test;
import static org.junit.Assert.*;

import com.sg.conditionals.StartHi;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StartHiTest {
    
    StartHi testMe = new StartHi();
    
    public StartHiTest() {
    }
    
    // Given a String, return true if the String starts with "hi" and false otherwise. 

    @Test
    public void testStartHi() {
        // startHi("hi there") -> true
        assertTrue(testMe.startHi("hi there"));
        // startHi("hi") -> true
        assertTrue(testMe.startHi("hi"));
        // startHi("high up") -> false
        assertFalse(testMe.startHi("high up"));
    }
    
}
