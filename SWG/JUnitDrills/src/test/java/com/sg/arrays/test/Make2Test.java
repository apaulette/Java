package com.sg.arrays.test;

import com.sg.arrays.Make2;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Make2Test {
    
    Make2 testMe = new Make2();
    
    public Make2Test(){
    }
    
    // Given 2 int arrays, a and b, return a new array length 2 containing, 
    // as much as will fit, the elements from a followed by the elements 
    // from b. The arrays may be any length, including 0, but there will 
    // be 2 or more elements available between the 2 arrays. 

    @Test
    public void testMake2() {
        // make2({4, 5}, {1, 2, 3}) -> {4, 5}
        Assert.assertArrayEquals(new int[]{4, 5}, testMe.make2(new int[]{4, 5}, new int[]{1, 2, 3}));
        // make2({4}, {1, 2, 3}) -> {4, 1}
        Assert.assertArrayEquals(new int[]{4, 1}, testMe.make2(new int[]{4}, new int[]{1, 2, 3}));
        // make2({}, {1, 2}) -> {1, 2}
        Assert.assertArrayEquals(new int[]{1, 2}, testMe.make2(new int[]{}, new int[]{1, 2}));

    }
}