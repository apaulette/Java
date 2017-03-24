package com.sg.strings.test;

import com.sg.strings.AtFirst;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AtFirstTest {
    
AtFirst testMe = new AtFirst();
    
    public AtFirstTest() {
    }
    
//    Given a String, return a String length 2 made of its first 2 
//    chars. If the String length is less than 2, use '@' for 
//    the missing chars. 
    
    @Test
    public void testFrontAndBack() {
    //    atFirst("hello") -> "he"
        assertEquals("he", testMe.atFirst("hello"));
    //    atFirst("hi") -> "hi"
        assertEquals("hi", testMe.atFirst("hi"));
    //    atFirst("h") -> "h@"
        assertEquals("h@", testMe.atFirst("h"));
    }

}