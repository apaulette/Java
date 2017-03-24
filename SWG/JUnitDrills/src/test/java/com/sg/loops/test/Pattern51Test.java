package com.sg.loops.test;

import com.sg.loops.Pattern51;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Pattern51Test {
    
    Pattern51 testMe = new Pattern51();
    
    public Pattern51Test(){
    }
    
    // Given an array of ints, return true if it contains a 2, 7, 1 
    // pattern -- a value, followed by the value plus 5, followed by 
    // the value minus 1.

    @Test
    public void testPattern51() {
        // pattern51({1, 2, 7, 1}) -> true
        assertTrue(testMe.pattern51(new int[] {1, 2, 7, 1}));
        // pattern51({1, 2, 8, 1}) -> false
        assertFalse(testMe.pattern51(new int[] {1, 2, 8, 1}));
        // pattern51({2, 7, 1}) -> true
        assertTrue(testMe.pattern51(new int[] {2, 7, 1}));
        // pattern51({0, 1, 4, 9, 3, 0, 1}) -> true
        assertTrue(testMe.pattern51(new int[] {0, 1, 4, 9, 3, 0, 1}));
    }
    
}