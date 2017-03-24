package com.sg.logic.test;

import com.sg.logic.AreInOrder;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AreInOrderTest {
    
    AreInOrder testMe = new AreInOrder();

    public AreInOrderTest() {
    }
 
    // Given three ints, a b c, return true if b is greater than a, 
    // and c is greater than b. However, with the exception that if
    // "bOk" is true, b does not need to be greater than a. 

    @Test
    public void testAreInOrder() {
        // areInOrder(1, 2, 4, false) → true
        assertTrue(testMe.areInOrder(1, 2, 4, false));
        // areInOrder(1, 2, 1, false) → false
        assertFalse(testMe.areInOrder(1, 2, 1, false));
        // areInOrder(1, 1, 2, true) → true
        assertTrue(testMe.areInOrder(1, 1, 2, true));
    }    
}