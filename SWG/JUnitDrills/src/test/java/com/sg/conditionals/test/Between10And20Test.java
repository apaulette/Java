package com.sg.conditionals.test;

import com.sg.conditionals.Between10And20;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Between10And20Test {
    
    Between10And20 testMe = new Between10And20();
    
    public Between10And20Test(){
    }
    
    // Given 2 int values, return true if either of them is in 
    // the range 10..20 inclusive. 

    @Test
    public void testBetween10And20() {
        // between10and20(12, 99) -> true
        assertTrue(testMe.between10and20(12, 99));
        // between10and20(21, 12) -> true
        assertTrue(testMe.between10and20(21, 12));
        // between10and20(8, 99) -> false
        assertFalse(testMe.between10and20(8, 99));
    }
    
}
