package com.sg.conditionals.test;

import com.sg.conditionals.NearHundred;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class NearHundredTest {

    NearHundred testMe = new NearHundred();

    public NearHundredTest() {
    }
    // Given an int n, return true if it is within 10 of 100 or 200.
    // Hint: Check out the Math class for absolute value

    @Test
    public void test() {
        
        // nearHundred(103) -> true
        assertTrue(testMe.nearHundred(103));

        // nearHundred(90) -> true
        assertTrue(testMe.nearHundred(90));

        // nearHundred(89) -> false
        assertFalse(testMe.nearHundred(89));

    }

}
