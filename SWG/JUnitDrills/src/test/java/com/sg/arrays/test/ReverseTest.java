package com.sg.arrays.test;

import com.sg.arrays.Reverse;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ReverseTest {
    
    Reverse testMe = new Reverse();
    
    public ReverseTest(){
    }
    
    // Given an array of ints length 3, return a new array with the 
    // elements in reverse order, so for example {1, 2, 3} becomes {3, 2, 1}. 

    @Test
    public void testReverse() {
        // reverse{1, 2, 3} -> {3, 2, 1}
        Assert.assertArrayEquals(new int[]{3, 2, 1}, testMe.reverse(new int[]{1, 2, 3}));
        // reverse{7, 8, 9} -> {9, 8, 7}
        Assert.assertArrayEquals(new int[]{9, 8, 7}, testMe.reverse(new int[]{7, 8, 9}));
        // reverse{4, 2, 5} -> {5, 2, 4}
        Assert.assertArrayEquals(new int[]{5, 2, 4}, testMe.reverse(new int[]{4, 2, 5}));
    }
    
}