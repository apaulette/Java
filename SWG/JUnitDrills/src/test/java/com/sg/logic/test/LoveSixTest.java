package com.sg.logic.test;

import com.sg.logic.LoveSix;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LoveSixTest {
    
    LoveSix testIt = new LoveSix();

    public LoveSixTest() {
    }
    
    // The number 6 is a truly great number. Given two int values, 
    // a and b, return true if either one is 6. Or if their sum 
    // or difference is 6.



    
    @Test
    public void testLoveSix() {
        
        // loveSix(6, 4) → true
        assertEquals(true, testIt.loveSix(6, 4));

        // loveSix(4, 5) → false
        assertEquals(false, testIt.loveSix(4, 5));
        
        // loveSix(1, 5) → true
        assertEquals(true, testIt.loveSix(1, 5));
        
    }    
    
}
