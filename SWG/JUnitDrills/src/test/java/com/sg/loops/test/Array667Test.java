package com.sg.loops.test;

import com.sg.loops.Array667;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Array667Test {
    
    Array667 testMe = new Array667();
    
    public Array667Test(){
    }
    
    // Given an array of ints, return the number of times that two 6's are 
    // next to each other in the array. Also count instances where the 
    // second "6" is actually a 7. 

    @Test
    public void testArray667() {
        // array667({6, 6, 2}) -> 1
        assertEquals(1, testMe.array667(new int[] {6, 6, 2}));
        // array667({6, 6, 2, 6}) -> 1
        assertEquals(1, testMe.array667(new int[] {6, 6, 2, 6}));
        // array667({6, 7, 2, 6}) -> 1
        assertEquals(1, testMe.array667(new int[] {6, 7, 2, 6}));
        // array667({6, 7, 2, 6, 6, 7}) -> 3
        assertEquals(3, testMe.array667(new int[] {6, 7, 2, 6, 6, 7}));
        // array667({6, 7, 2, 6, 7, 6}) -> 2
        assertEquals(2, testMe.array667(new int[] {6, 7, 2, 6, 7, 6}));
    }
    
}