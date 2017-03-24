package com.sg.conditionals.test;

import com.sg.conditionals.Diff21;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Diff21Test {
    
    Diff21 testIt = new Diff21();
    
    public Diff21Test() {
    }
    
    // Given an int n, return the absolute value of the difference 
    // between n and 21, except return double the absolute value of 
    // the difference if n is over 21. 
    
    @Test
    public void test() {
        
        // diff21(23) -> 4
        assertEquals(4, testIt.diff21(23));

        // diff21(10) -> 11
        assertEquals(11, testIt.diff21(10));

        // diff21(21) -> 0        
        assertEquals(0, testIt.diff21(21));

    }

}