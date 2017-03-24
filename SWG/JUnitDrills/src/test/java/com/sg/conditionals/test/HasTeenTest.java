package com.sg.conditionals.test;

import com.sg.conditionals.HasTeen;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class HasTeenTest {

    HasTeen testMe = new HasTeen();

    public HasTeenTest() {
    }

    // We'll say that a number is "teen" if it is in the range 13..19 
    // inclusive. Given 3 int values, return true if 1 or more of them are teen. 

    @Test
    public void testHasTeen() {
        // hasTeen(13, 20, 10) -> true
        assertTrue(testMe.hasTeen(13, 20, 10));
        // hasTeen(20, 19, 10) -> true
        assertTrue(testMe.hasTeen(20, 19, 10));
        // hasTeen(20, 10, 12) -> false
        assertFalse(testMe.hasTeen(20, 10, 12));
    }

}