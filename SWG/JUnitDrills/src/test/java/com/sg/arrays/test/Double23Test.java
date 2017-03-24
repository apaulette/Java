package com.sg.arrays.test;

import com.sg.arrays.Double23;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Double23Test {
    
    Double23 testMe = new Double23();
    
    public Double23Test(){
    }
    
    // Given an int array, return true if the array contains 2 twice, or 3 twice. 

    @Test
    public void testDouble23() {
        // double23({2, 2, 3}) -> true
        assertTrue(testMe.double23(new int[]{2, 2, 3}));
        // double23({3, 4, 5, 3}) -> true
        assertTrue(testMe.double23(new int[]{3, 4, 5, 3}));
        // double23({2, 3, 2, 2}) -> false
        assertFalse(testMe.double23(new int[]{2, 3, 2, 2}));
    }
}