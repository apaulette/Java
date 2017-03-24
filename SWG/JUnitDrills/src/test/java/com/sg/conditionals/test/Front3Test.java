package com.sg.conditionals.test;

import com.sg.conditionals.Front3;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Front3Test {
    
    Front3 testMe = new Front3();
    
    public Front3Test() {
    }
    // Given a String, we'll say that the front is the first 3 chars of the 
    // String. If the String length is less than 3, the front is whatever 
    // is there. Return a new String which is 3 copies of the front. 

    @Test
    public void test() {
        
        // front3("Microsoft") -> "MicMicMic"
        assertEquals("MicMicMic", testMe.front3("Microsoft"));

        // front3("Chocolate") -> "ChoChoCho"
        assertEquals("ChoChoCho", testMe.front3("Chocolate"));
        
        // front3("at") -> "atatat"
        assertEquals("atatat", testMe.front3("at"));

    }

}