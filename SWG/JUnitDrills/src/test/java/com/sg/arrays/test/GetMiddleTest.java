package com.sg.arrays.test;

import com.sg.arrays.GetMiddle;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class GetMiddleTest {
    
    GetMiddle testMe = new GetMiddle();
    
    public GetMiddleTest(){
    }
    
    // Given 2 int arrays, a and b, each length 3, return a new array 
    // length 2 containing their middle elements. 

    @Test
    public void testGetMiddle() {
        // getMiddle({1, 2, 3}, {4, 5, 6}) -> {2, 5}
        Assert.assertArrayEquals(new int[]{2, 5}, testMe.getMiddle(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        // getMiddle({7, 7, 7}, {3, 8, 0}) -> {7, 8}
        Assert.assertArrayEquals(new int[]{2, 5}, testMe.getMiddle(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        // getMiddle({5, 2, 9}, {1, 4, 5}) -> {2, 4}
        Assert.assertArrayEquals(new int[]{2, 5}, testMe.getMiddle(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
    }
    
}