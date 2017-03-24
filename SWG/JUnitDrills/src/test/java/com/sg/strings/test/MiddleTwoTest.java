package com.sg.strings.test;

import com.sg.strings.MiddleTwo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MiddleTwoTest {
    
    MiddleTwo testMe = new MiddleTwo();
    
    public MiddleTwoTest() {
    }
    // Given a String of even length, return a String made of the middle 
    // two chars, so the String "String" yields "ri". The String length 
    // will be at least 2. 

    @Test
    public void test() {
        
        // middleTwo("String") -> "ri"
        assertEquals("ri", testMe.middleTwo("String"));
        // 
        // middleTwo("code") -> "od"
        assertEquals("od", testMe.middleTwo("code"));
        // 
        // middleTwo("Practice") -> "ct"    
        assertEquals("ct", testMe.middleTwo("Practice"));
        
    }

}