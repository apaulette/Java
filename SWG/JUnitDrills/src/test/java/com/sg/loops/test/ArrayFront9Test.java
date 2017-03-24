package com.sg.loops.test;

import com.sg.loops.ArrayFront9;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ArrayFront9Test {

    ArrayFront9 testIt = new ArrayFront9();

    public ArrayFront9Test() {
    }

    // Given an array of ints, return true if one of the first 4 elements 
    // in the array is a 9. The array length may be less than 4. 
    
    @Test
    public void testArrayFront9() {
        // arrayFront9({1, 2, 9, 3, 4}) -> true
        int[] numbers1 = new int[]{1, 2, 9, 3, 4};
        assertTrue(testIt.arrayFront9(numbers1));

        // arrayFront9({1, 2, 3, 4, 9}) -> false
        int[] numbers2 = new int[]{1, 2, 3, 4, 9};
        assertFalse(testIt.arrayFront9(numbers2));

        // arrayFront9({1, 2, 3, 4, 5}) -> false        
        int[] numbers3 = new int[]{1, 2, 3, 4, 5};
        assertFalse(testIt.arrayFront9(numbers3));

        // arrayFront9({8, 9, 3}) -> true        
        int[] numbers4 = new int[]{8, 9, 3};
        assertTrue(testIt.arrayFront9(numbers4));

        // arrayFront9({2, 7, 1}) -> false        
        int[] numbers5 = new int[]{2, 7, 1};
        assertFalse(testIt.arrayFront9(numbers5));
        
    }

}
