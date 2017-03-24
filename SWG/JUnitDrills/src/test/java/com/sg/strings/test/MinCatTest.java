package com.sg.strings.test;

import com.sg.strings.MinCat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MinCatTest {
    
    MinCat testMe = new MinCat();
    
    public MinCatTest() {
    }
    
    // Given two Strings, append them together (known as "concatenation")
    // and return the result. However, if the Strings are different lengths, 
    // omit chars from the longer String so it is the same length as the 
    // shorter String. So "Hello" and "Hi" yield "loHi". The Strings may be 
    // any length.
    
    @Test
    public void testMinCat() {
        // minCat("Hello", "Hi") -> "loHi"
        assertEquals("loHi", testMe.minCat("Hello", "Hi"));
        // minCat("Hello", "java") -> "ellojava"
        assertEquals("ellojava", testMe.minCat("Hello", "java"));
        // minCat("java", "Hello") -> "javaello"
        assertEquals("javaello", testMe.minCat("java", "Hello"));
    }
}
