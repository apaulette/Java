package com.sg.arrays.test;

import com.sg.arrays.Fix23;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Fix23Test {
    
    Fix23 testMe = new Fix23();
    
    public Fix23Test(){
    }
    
    // Given an int array length 3, if there is a 2 in the array immediately 
    // followed by a 3, set the 3 element to 0. Return the changed array. 

    @Test
    public void testFix23() {
        // fix23({1, 2, 3}) -> {1, 2, 0}
        Assert.assertArrayEquals(new int[]{1, 2, 0}, testMe.fix23(new int[]{1, 2, 3}));
        // fix23({2, 3, 5}) -> {2, 0, 5}
        Assert.assertArrayEquals(new int[]{2, 0, 5}, testMe.fix23(new int[]{2, 3, 5}));
        // fix23({1, 2, 1}) -> {1, 2, 1}
        Assert.assertArrayEquals(new int[]{1, 2, 1}, testMe.fix23(new int[]{1, 2, 1}));
    }
}