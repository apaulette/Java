package com.sg.loops.test;

import com.sg.loops.Count9;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Count9Test {

    Count9 testIt = new Count9();

    public Count9Test() {
    }

    /*
    Given an array of ints, return the number of 9's in the array. 
     */
    
    @Test
    public void testCount9() {
        // count9({1, 2, 9}) -> 1
        int[] numbers1 = new int[]{1, 2, 9};
        assertEquals(1, testIt.count9(numbers1));
        // count9({1, 9, 9}) -> 2
        int[] numbers2 = new int[]{1, 9, 9};
        assertEquals(2, testIt.count9(numbers2));
        // count9({1, 9, 9, 3, 9}) -> 3
        int[] numbers3 = new int[]{1, 9, 9, 3, 9};
        assertEquals(3, testIt.count9(numbers3));
    }
}
