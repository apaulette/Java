package com.sg.strings.test;

import com.sg.strings.LongInMiddle;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LongInMiddleTest {
    
    LongInMiddle testMe = new LongInMiddle();
    
    public LongInMiddleTest() {
    }
    // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 

    @Test
    public void test() {

        // longInMiddle("Hello", "hi") -> "hiHellohi"
        assertEquals("hiHellohi", testMe.longInMiddle("Hello", "hi"));
        // 
        // longInMiddle("hi", "Hello") -> "hiHellohi"
        assertEquals("hiHellohi", testMe.longInMiddle("hi", "Hello"));
        // 
        // longInMiddle("aaa", "b") -> "baaab"
        assertEquals("baaab", testMe.longInMiddle("aaa", "b"));
        
    }

}