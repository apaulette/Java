package com.sg.conditionals.test;

import com.sg.conditionals.FrontBack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FrontBackTest {
    
    FrontBack testMe = new FrontBack();
    
    public FrontBackTest() {
    }
    // Given a String, return a new String where the first 
    // and last chars have been exchanged. 

    @Test
    public void test() {
        
        // frontBack("code") -> "eodc"
        assertEquals("eodc", testMe.frontBack("code"));

        // frontBack("a") -> "a"
        assertEquals("a", testMe.frontBack("a"));

        // frontBack("ab") -> "ba"
        assertEquals("ba", testMe.frontBack("ab"));
        
    }

}