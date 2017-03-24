package com.sg.arrays.test;

import com.sg.arrays.HigherWins;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class HigherWinsTest {
    
    HigherWins testMe = new HigherWins();
    
    public HigherWinsTest(){
    }
    
    // Given an array of ints, figure out which is larger between the 
    // first and last elements in the array, and set all the other 
    // elements to be that value. Return the changed array. 

    @Test
    public void testHigherWins() {
        // higherWins({1, 2, 3}) -> {3, 3, 3}
        Assert.assertArrayEquals(new int[]{3, 3, 3}, testMe.higherWins(new int[]{1, 2, 3}));
        // higherWins({11, 5, 9}) -> {11, 11, 11}
        Assert.assertArrayEquals(new int[]{11, 11, 11}, testMe.higherWins(new int[]{11, 5, 9}));
        // higherWins({2, 11, 3}) -> {3, 3, 3}
        Assert.assertArrayEquals(new int[]{3, 3, 3}, testMe.higherWins(new int[]{2, 11, 3}));
        // higherWins({42, 17, 24, 39}) -> {42, 42, 42, 42}
        Assert.assertArrayEquals(new int[]{42, 42, 42, 42}, testMe.higherWins(new int[]{42, 17, 24, 39}));
        // higherWins({42, 16, 5, 37, 42}) -> {42, 42, 42, 42, 42}
        Assert.assertArrayEquals(new int[]{42, 42, 42, 42, 42}, testMe.higherWins(new int[]{42, 16, 5, 37, 42}));
    }
}