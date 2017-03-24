package com.sg.conditionals.test;

import com.sg.conditionals.IxStart;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class IxStartTest {

    IxStart testMe = new IxStart();

    public IxStartTest() {
    }

    // Return true if the given String begins with "*ix", the '*' can be 
    // anything, so "pix", "9ix" .. all count. 

    @Test
    public void testIxStart() {
        // ixStart("mix snacks") -> true
        assertTrue(testMe.ixStart("mix snacks"));
        // ixStart("pix snacks") -> true
        assertTrue(testMe.ixStart("pix snacks"));
        // ixStart("piz snacks") -> false
        assertFalse(testMe.ixStart("piz snacks"));
    }

}