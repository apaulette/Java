package com.sg.logic.test;

import com.sg.logic.InRange;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class InRangeTest {
    
    InRange testIt = new InRange();

    public InRangeTest() {
    }
    
    // Given a number n, return true if n is in the range 1..10, 
    // inclusive. Unless "outsideMode" is true, in which case 
    // return true if the number is less or equal to 1, or greater 
    // or equal to 10. 
    
    @Test
    public void testInRange() {
        
        // inRange(5, false) → true
        assertTrue(testIt.inRange(5, false));

        // inRange(11, false) → false
        assertFalse(testIt.inRange(11, false));

        // inRange(11, true) → true
        assertTrue(testIt.inRange(11, true));

    }    
    
}
