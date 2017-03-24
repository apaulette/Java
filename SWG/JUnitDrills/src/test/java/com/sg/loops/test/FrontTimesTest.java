package com.sg.loops.test;

import com.sg.loops.FrontTimes;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FrontTimesTest {

    FrontTimes testIt = new FrontTimes();

    public FrontTimesTest() {
    }

    /*
    Given a String and a non-negative int n, we'll say that the 
    front of the String is the first 3 chars, or whatever is there if 
    the String is less than length 3. Return n copies of the front; 
     */
    @Test
    public void test() {
        // frontTimes("Chocolate", 2) -> "ChoCho"
        assertTrue("ChoCho".equals(testIt.frontTimes("Chocolate", 2)));
        // frontTimes("Chocolate", 3) -> "ChoChoCho"
        assertTrue("ChoChoCho".equals(testIt.frontTimes("Chocolate", 3)));
        // frontTimes("Abc", 3) -> "AbcAbcAbc"
        assertTrue("AbcAbcAbc".equals(testIt.frontTimes("Abc", 3)));
    }

}
