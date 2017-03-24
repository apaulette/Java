package com.sg.logic.test;

import com.sg.logic.Mod20;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Mod20Test {
    
    Mod20 testMe = new Mod20();

    public Mod20Test() {
    }
 
    // Return true if the given non-negative number is 1 or 2 more than a 
    // multiple of 20. See also: Introduction to Mod 

    @Test
    public void testMod20() {
        // mod20(20) → false
        assertFalse(testMe.mod20(20));
        // mod20(21) → true
        assertTrue(testMe.mod20(21));
        // mod20(22) → true
        assertTrue(testMe.mod20(22));
    }    
    
}