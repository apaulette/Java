package com.sg.conditionals.test;

import com.sg.conditionals.SumDouble;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SumDoubleTest {

    SumDouble testMe = new SumDouble();

    public SumDoubleTest() {
    }
    // Given two int values, return their sum. However, if the two values are 
    // the same, then return double their sum. 

    @Test
    public void test() {
        
        // sumDouble(1, 2) -> 3
        assertEquals(3, testMe.sumDouble(1, 2));

        // sumDouble(3, 2) -> 5
        assertEquals(5, testMe.sumDouble(3, 2));

        // sumDouble(2, 2) -> 8
        assertEquals(8, testMe.sumDouble(2, 2));

    }

}
