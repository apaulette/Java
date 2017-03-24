package com.sg.strings.test;

import com.sg.strings.TrimOne;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TrimOneTest {

    TrimOne testMe = new TrimOne();

    public TrimOneTest() {
    }
    // Given a String, return a version without the first and last char, 
    // so "Hello" yields "ell". The String length will be at least 2. 

    @Test
    public void test() {

        // trimOne("Hello") -> "ell"
        assertEquals("ell", testMe.trimOne("Hello"));
        // 
        // trimOne("java") -> "av"
        assertEquals("av", testMe.trimOne("java"));
        // 
        // trimOne("coding") -> "odin"
        assertEquals("odin", testMe.trimOne("coding"));
        
        // trimOne("He") -> ""
        assertEquals("", testMe.trimOne("Hi"));
    }

}