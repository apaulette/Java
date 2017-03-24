package com.sg.conditionals.test;

import com.sg.conditionals.Max;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MaxTest {

    Max testMe = new Max();

    public MaxTest() {
    }

    // Given three int values, a b c, return the largest. 

    @Test
    public void testMax() {
        // max(1, 2, 3) -> 3
        assertEquals(3, testMe.max(1, 2, 3));
        // max(1, 3, 2) -> 3
        assertEquals(3, testMe.max(1, 3, 2));
        // max(3, 2, 1) -> 3
        assertEquals(3, testMe.max(3, 2, 1));
        // max(2, 7, 4) -> 7
        assertEquals(7, testMe.max(2, 7, 4));
    }

}