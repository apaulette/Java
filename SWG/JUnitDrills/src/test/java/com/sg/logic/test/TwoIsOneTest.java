package com.sg.logic.test;

import com.sg.logic.TwoIsOne;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TwoIsOneTest {
    
    TwoIsOne testMe = new TwoIsOne();

    public TwoIsOneTest() {
    }
 
    // Given three ints, a b c, return true if it is possible to add 
    // two of the ints to get the third. 

    @Test
    public void testTwoIsOne() {
        // twoIsOne(1, 2, 3) → true
        assertTrue(testMe.twoIsOne(1, 2, 3));
        // twoIsOne(3, 1, 2) → true
        assertTrue(testMe.twoIsOne(3, 1, 2));
        // twoIsOne(3, 2, 2) → false
        assertFalse(testMe.twoIsOne(3, 2, 2));
    }    
    
}