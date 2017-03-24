package com.sg.arrays.test;

import com.sg.arrays.FirstLast6;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FirstLast6Test {
    
    FirstLast6 testIt = new FirstLast6();

    public FirstLast6Test() {
    }
    
    //    Given an array of ints, return true if 6 appears as 
    //    either the first or last element in the array.
    //    The array will be length 1 or more. 
    
    @Test
    public void testFirstLast6() {
        //    firstLast6({1, 2, 6}) -> true
        int[] numbers1 = {1, 2, 6};
        assertTrue(testIt.firstLast6(numbers1));
        
        //    firstLast6({6, 1, 2, 3}) -> true
        int[] numbers2 = {6, 1, 2, 3};
        assertTrue(testIt.firstLast6(numbers2));
        
        //    firstLast6({13, 6, 1, 2, 3}) -> false
        int[] numbers3 = {13, 6, 1, 2, 3};
        assertFalse(testIt.firstLast6(numbers3));
        
    }
}