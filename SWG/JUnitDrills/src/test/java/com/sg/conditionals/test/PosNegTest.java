package com.sg.conditionals.test;

import com.sg.conditionals.PosNeg;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class PosNegTest {
    
    PosNeg testMe = new PosNeg();
    
    public PosNegTest() {
    }
    // Given two int values, return true if one is negative and one is 
    // positive. Except if the parameter "negative" is true, then return 
    // true only if both are negative. 

    @Test
    public void test() {
        
        // posNeg(1, -1, false) -> true
        assertTrue(testMe.posNeg(1, -1, false));

        // posNeg(-1, 1, false) -> true
        assertTrue(testMe.posNeg(-1, 1, false));

        // posNeg(-4, -5, true) -> true
        assertTrue(testMe.posNeg(-4, 5, true));

    }

}