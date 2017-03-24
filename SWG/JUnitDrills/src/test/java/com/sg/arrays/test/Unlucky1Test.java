package com.sg.arrays.test;

import com.sg.arrays.Unlucky1;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Unlucky1Test {
    
    Unlucky1 testMe = new Unlucky1();
    
    public Unlucky1Test(){
    }
    
    // We'll say that a 1 immediately followed by a 3 in an array is an
    // "unlucky" 1. Return true if the given array contains an unlucky 1 
    // in the first 2 or last 2 positions in the array. 

    @Test
    public void testUnlucky1() {
        // unlucky1({1, 3, 4, 5}) -> true
        assertTrue(testMe.unlucky1(new int[]{1, 3, 4, 5}));
        // unlucky1({2, 1, 3, 4, 5}) -> true
        assertTrue(testMe.unlucky1(new int[]{2, 1, 3, 4, 5}));
        // unlucky1({1, 1, 1}) -> false
        assertFalse(testMe.unlucky1(new int[]{1, 1, 1}));
    }
}