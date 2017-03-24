package com.sg.loops.test;

import com.sg.loops.DoubleX;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class DoubleXTest {

    DoubleX testIt = new DoubleX();

    public DoubleXTest() {
    }

    //    Given a String, return true if the first instance of "x" in 
    //    the String is immediately followed by another "x". 
    @Test
    public void testDoubleX() {

        //    doubleX("axxbb") -> true
        assertTrue(testIt.doubleX("axxbb"));
        //    doubleX("axaxxax") -> false
        assertFalse(testIt.doubleX("axaxxax"));
        //    doubleX("xxxxx") -> true    
        assertTrue(testIt.doubleX("xxxxx"));

    }

}
