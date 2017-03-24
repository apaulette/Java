package com.sg.conditionals.test;

import com.sg.conditionals.Makes10;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Makes10Test {

    Makes10 testIt = new Makes10();

    public Makes10Test() {
    }
    // Given two ints, a and b, return true if one if them is 
    // 10 or if their sum is 10. 

    @Test
    public void test() {
        
        // makes10(9, 10) -> true
        assertTrue(testIt.makes10(9, 10));

        // makes10(9, 9) -> false
        assertFalse(testIt.makes10(9, 9));

        // makes10(1, 9) -> true   
        assertTrue(testIt.makes10(1, 9));
        
    }

}