package com.sg.conditionals.test;

import com.sg.conditionals.BackAround;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class BackAroundTest {
    
    BackAround testMe = new BackAround();
    
    public BackAroundTest(){
    }
    
    // Given a String, take the last char and return a new String with the 
    // last char added at the front and back, so "cat" yields "tcatt". 
    // The original String will be length 1 or more. 

    @Test
    public void testBackAround() {
        // backAround("cat") -> "tcatt"
        assertEquals("tcatt", testMe.backAround("cat"));
        // backAround("Hello") -> "oHelloo"
        assertEquals("oHelloo", testMe.backAround("Hello"));
        // backAround("a") -> "aaa"
        assertEquals("aaa", testMe.backAround("a"));
    }
    
}
