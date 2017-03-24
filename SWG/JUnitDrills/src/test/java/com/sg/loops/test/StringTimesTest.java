package com.sg.loops.test;

import com.sg.loops.StringTimes;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StringTimesTest {

    StringTimes testIt = new StringTimes();

    public StringTimesTest() {
    }

    //    Given a String and a non-negative int n, return a larger String that
    //    is n copies of the original String. 
    @Test
    public void test() {
        //    stringTimes("Hi", 2) -> "HiHi"
        assertTrue("HiHi".equals(testIt.stringTimes("Hi", 2)));
        //    stringTimes("Hi", 3) -> "HiHiHi"
        assertTrue("HiHiHi".equals(testIt.stringTimes("Hi", 3)));
        //    stringTimes("Hi", 1) -> "Hi"        
        assertTrue("Hi".equals(testIt.stringTimes("Hi", 1)));
    }

}
