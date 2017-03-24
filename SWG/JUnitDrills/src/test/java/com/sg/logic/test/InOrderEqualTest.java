package com.sg.logic.test;

import com.sg.logic.InOrderEqual;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class InOrderEqualTest {
    
    InOrderEqual testMe = new InOrderEqual();

    public InOrderEqualTest() {
    }
 
    // Given three ints, a b c, return true if they are in strict 
    // increasing order, such as 2 5 11, or 5 6 7, but not 6 5 7 or 5 5 7.
    // However, with the exception that if "equalOk" is true, equality 
    // is allowed, such as 5 5 7 or 5 5 5. 

    @Test
    public void testInOrderEqual() {
        // inOrderEqual(2, 5, 11, false) → true
        assertTrue(testMe.inOrderEqual(2, 5, 11, false));
        // inOrderEqual(5, 7, 6, false) → false
        assertFalse(testMe.inOrderEqual(5, 7, 6, false));
        // inOrderEqual(5, 5, 7, true) → true
        assertTrue(testMe.inOrderEqual(5, 5, 7, true));
        // inOrderEqual(5, 5, 4, true) → false
        assertFalse(testMe.inOrderEqual(5, 5, 4, true));
    }    
}