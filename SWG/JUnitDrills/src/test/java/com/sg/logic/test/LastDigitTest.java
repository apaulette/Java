package com.sg.logic.test;

import com.sg.logic.LastDigit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LastDigitTest {
    
    LastDigit testMe = new LastDigit();

    public LastDigitTest() {
    }
 
    // Given three ints, a b c, return true if two or more of them have 
    // the same rightmost digit. The ints are non-negative. 

    @Test
    public void testLastDigit() {
        // lastDigit(23, 19, 13) → true
        assertTrue(testMe.lastDigit(23, 19, 13));
        // lastDigit(23, 19, 12) → false
        assertFalse(testMe.lastDigit(23, 19, 12));
        // lastDigit(23, 19, 3) → true
        assertTrue(testMe.lastDigit(23, 19, 3));
    }    
}