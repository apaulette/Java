package com.sg.logic.test;

import com.sg.logic.Mod35;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Mod35Test {
    
    Mod35 testMe = new Mod35();

    public Mod35Test() {
    }
 
    // Return true if the given non-negative number is a multiple of 
    // 3 or 5, but not both. Use the % "mod" operator

    @Test
    public void testMod35() {
        // mod35(3) → true
        assertTrue(testMe.mod35(3));
        // mod35(10) → true
        assertTrue(testMe.mod35(10));
        // mod35(15) → false
        assertFalse(testMe.mod35(15));
    }    
    
}