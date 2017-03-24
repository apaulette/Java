package com.sg.conditionals.test;

import com.sg.conditionals.NotString;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class NotStringTest {
    
    NotString testMe = new NotString();
    
    public NotStringTest() {
    }
    // Given a String, return a new String where "not " has been added 
    // to the front. However, if the String already begins with "not", 
    // return the String unchanged.
    // 
    // Hint: Look up how to use "SubString" in c#

    @Test
    public void test() {
        
        // notString("candy") -> "not candy"
        assertEquals("not candy", testMe.notString("candy"));

        // notString("x") -> "not x"
        assertEquals("not x", testMe.notString("x"));

        // notString("not bad") -> "not bad"        
        assertEquals("not bad", testMe.notString("not bad"));
        
    }

}