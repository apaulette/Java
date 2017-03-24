package com.sg.conditionals.test;

import com.sg.conditionals.IcyHot;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class IcyHotTest {
    
    IcyHot testMe = new IcyHot();
    
    public IcyHotTest() {
    }
    
    // Given two temperatures, return true if one is less than 0 and 
    // the other is greater than 100. 

    @Test
    public void testIcyHot() {
        // icyHot(120, -1) -> true
        assertTrue(testMe.icyHot(120, -1));
        // icyHot(-1, 120) -> true
        assertTrue(testMe.icyHot(-1, 120));
        // icyHot(2, 120) -> false
        assertFalse(testMe.icyHot(2, 120));
    }
    
}