package com.sg.logic.test;

import com.sg.logic.SpecialEleven;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SpecialElevenTest {
    
    SpecialEleven testIt = new SpecialEleven();

    public SpecialElevenTest() {
    }
    
 
// We'll say a number is special if it is a multiple of 11 
// or if it is one more than a multiple of 11. Return true
// if the given non-negative number is special. Use the 
// % "mod" operator


    
    @Test
    public void testSpecialEleven() {

        // specialEleven(22) → true
        assertTrue(testIt.specialEleven(22));
        
        // specialEleven(23) → true
        assertTrue(testIt.specialEleven(23));

        // specialEleven(24) → false
        assertFalse(testIt.specialEleven(24));

    }    
    
}