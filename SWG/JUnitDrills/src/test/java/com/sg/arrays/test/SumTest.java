package com.sg.arrays.test;

import com.sg.arrays.Sum;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SumTest {
    
    Sum testMe = new Sum();

    public SumTest() {
    }
    
    // Given an array of ints, return the sum of all the elements. 

    @Test
    public void testSum() {
        // sum({1, 2, 3}) -> 6
        assertEquals(6, testMe.sum(new int[]{1, 2, 3}));
        // sum({5, 11, 2}) -> 18
        assertEquals(18, testMe.sum(new int[]{5, 11, 2}));
        // sum({7, 0, 0}) -> 7
        assertEquals(7, testMe.sum(new int[]{7, 0, 0}));
    }

}