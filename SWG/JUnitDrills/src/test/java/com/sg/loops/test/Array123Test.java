package com.sg.loops.test;

import com.sg.loops.Array123;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Array123Test {
    
    Array123 testMe = new Array123();
    
    public Array123Test(){
    }
    
    // Given an array of ints, return true if .. 1, 2, 3, .. appears
    // in the array somewhere. 

    @Test
    public void testArray123() {
        // array123({1, 1, 2, 3, 1}) -> true
        int[] numbers1 = {1, 1, 2, 3, 1};
        assertTrue(testMe.array123(numbers1));
        
        // array123({1, 1, 2, 4, 1}) -> false
        int[] numbers2 = {1, 1, 2, 4, 1};
        assertFalse(testMe.array123(numbers2));
        
        // array123({1, 1, 2, 1, 2, 3}) -> true
        int[] numbers3 = {1, 1, 2, 1, 2, 3};
        assertTrue(testMe.array123(numbers3));
    }
    
}