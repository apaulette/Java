package com.sg.conditionals.test;

import com.sg.conditionals.EndUp;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class EndUpTest {
    
    EndUp testMe = new EndUp();
    
    public EndUpTest(){
    }
    
    // Given a String, return a new String where the last 3 chars are now 
    // in upper case. If the String has less than 3 chars, uppercase 
    // whatever is there. 

    @Test
    public void testEndUp() {
        // endUp("Hello") -> "HeLLO"
        assertEquals("HeLLO", testMe.endUp("Hello"));
        // endUp("hi there") -> "hi thERE"
        assertEquals("hi thERE", testMe.endUp("hi there"));
        // endUp("hi") -> "HI"
        assertEquals("HI", testMe.endUp("hi"));
        // endUp("hi") -> "HI"
        assertEquals("hIGH", testMe.endUp("high"));
    }
    
}