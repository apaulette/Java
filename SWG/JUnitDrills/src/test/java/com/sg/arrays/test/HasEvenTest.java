package com.sg.arrays.test;

import com.sg.arrays.HasEven;
import org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class HasEvenTest {
    
    HasEven testMe = new HasEven();
    
    public HasEvenTest(){
    }
    
    // Given an int array , return true if it contains an 
    // even number (HINT: Use Mod (%)). 

    @Test
    public void testHasEven() {
        // hasEven({2, 5}) -> true
        assertTrue(testMe.hasEven(new int[]{2, 5}));
        // hasEven({4, 3}) -> true
        assertTrue(testMe.hasEven(new int[]{4, 3}));
        // hasEven({7, 5}) -> false
        assertFalse(testMe.hasEven(new int[]{7, 5}));
    }
}