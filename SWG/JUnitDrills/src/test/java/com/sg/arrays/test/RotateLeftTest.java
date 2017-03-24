package com.sg.arrays.test;

import com.sg.arrays.RotateLeft;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RotateLeftTest {
    
    RotateLeft testMe = new RotateLeft();

    public RotateLeftTest() {
    }
    
    // Given an array of ints, return an array with the elements 
    // "rotated left" so {1, 2, 3} yields {2, 3, 1}. 

    @Test
    public void testRotateLeft() {
        // rotateLeft({1, 2, 3}) -> {2, 3, 1}
        Assert.assertArrayEquals(new int[]{2, 3, 1}, testMe.rotateLeft(new int[]{1, 2, 3}));
        // rotateLeft({5, 11, 9}) -> {11, 9, 5}
        Assert.assertArrayEquals(new int[]{11, 9, 5}, testMe.rotateLeft(new int[]{5, 11, 9}));
        // rotateLeft({7, 0, 0}) -> {0, 0, 7}
        Assert.assertArrayEquals(new int[]{0, 0, 7}, testMe.rotateLeft(new int[]{7, 0, 0}));
    }

}