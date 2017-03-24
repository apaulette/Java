package com.sg.loops.test;

import com.sg.loops.StringSplosion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StringSplosionTest {

    StringSplosion testIt = new StringSplosion();

    public StringSplosionTest() {
    }

    /*
    Given a non-empty String like "Code" return a String like "CCoCodCode".
    (first char, first two, first 3, etc)
    */
    
    @Test
    public void testStringSplosion() {
        // stringSplosion("Code") -> "CCoCodCode"
        assertEquals("CCoCodCode", testIt.stringSplosion("Code"));
        // stringSplosion("abc") -> "aababc"
        assertEquals("aababc", testIt.stringSplosion("abc"));
        // stringSplosion("ab") -> "aab"      
        assertEquals("aab", testIt.stringSplosion("ab"));
    }

}
