package com.sg.conditionals.test;

import com.sg.conditionals.EveryNth;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class EveryNthTest {
    
    EveryNth testMe = new EveryNth();
    
    public EveryNthTest(){
    }
    
    // Given a non-empty String and an int N, return the String made 
    // starting with char 0, and then every Nth char of the String. 
    // So if N is 3, use char 0, 3, 6, ... and so on. N is 1 or more. 

    @Test
    public void testEveryNth() {
        // everyNth("Miracle", 2) -> "Mrce"
        assertEquals("Mrce", testMe.everyNth("Miracle", 2));
        // everyNth("abcdefg", 2) -> "aceg"
        assertEquals("aceg", testMe.everyNth("abcdefg", 2));
        // everyNth("abcdefg", 3) -> "adg"
        assertEquals("adg", testMe.everyNth("abcdefg", 3));

    }
    
}