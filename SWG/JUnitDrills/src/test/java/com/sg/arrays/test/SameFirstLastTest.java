package com.sg.arrays.test;

import com.sg.arrays.SameFirstLast;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SameFirstLastTest {
    
    SameFirstLast testIt = new SameFirstLast();

    public SameFirstLastTest() {
    }
    
    //    Given an array of ints, return true if the array is 
    //    length 1 or more, and the first element 
    //    and the last element are equal. 
    
    @Test
    public void testSameFirstLast() {
        //    sameFirstLast({1, 2, 3}) -> false
        int[] numbers1 = new int[]{1, 2, 3};
        assertFalse(testIt.sameFirstLast(numbers1));
        //    sameFirstLast({1, 2, 3, 1}) -> true
        int[] numbers2 = new int[]{1, 2, 3, 1};
        assertTrue(testIt.sameFirstLast(numbers2));
        //    sameFirstLast({1, 2, 1}) -> true   
        int[] numbers3 = new int[]{1, 2, 1};
        assertTrue(testIt.sameFirstLast(numbers3));
    }

}
