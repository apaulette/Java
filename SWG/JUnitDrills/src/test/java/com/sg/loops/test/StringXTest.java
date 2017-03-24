package com.sg.loops.test;

import com.sg.loops.StringX;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StringXTest {
    
    StringX testMe = new StringX();
    
    public StringXTest(){
    }
    
    // Given a String, return a version where all the "x" have been removed. 
    // Except an "x" at the very start or end should not be removed. 

    @Test
    public void testStringX() {
        // stringX("xxHxix") -> "xHix"
        assertEquals("xHix", testMe.stringX("xxHxix"));
        // stringX("abxxxcd") -> "abcd"
        assertEquals("abcd", testMe.stringX("abxxxcd"));
        // stringX("xabxxxcdx") -> "xabcdx"
        assertEquals("xabcdx", testMe.stringX("xabxxxcdx"));
    }
    
}