package com.sg.arrays.test;

import com.sg.arrays.KeepLast;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class KeepLastTest {
    
    KeepLast testMe = new KeepLast();
    
    public KeepLastTest(){
    }
    
    // Given an int array, return a new array with double the length 
    // where its last element is the same as the original array, and 
    // all the other elements are 0. The original array will be 
    // length 1 or more. Note: by default, a new int array contains all 0's. 

    @Test
    public void testKeepLast() {
        // keepLast({4, 5, 6}) -> {0, 0, 0, 0, 0, 6}
        Assert.assertArrayEquals(new int[]{0, 0, 0, 0, 0, 6}, testMe.keepLast(new int[]{4, 5, 6}));
        // keepLast({1, 2}) -> {0, 0, 0, 2}
        Assert.assertArrayEquals(new int[]{0, 0, 0, 2}, testMe.keepLast(new int[]{1, 2}));
        // keepLast({3}) -> {0, 3}
        Assert.assertArrayEquals(new int[]{0, 3}, testMe.keepLast(new int[]{3}));
    }
}