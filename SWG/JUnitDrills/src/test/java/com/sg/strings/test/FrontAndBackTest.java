package com.sg.strings.test;

import com.sg.strings.FrontAndBack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FrontAndBackTest {
    
FrontAndBack testMe = new FrontAndBack();
    
    public FrontAndBackTest() {
    }
    
    //    Given a String and an int n, return a String made of 
    //    the first and last n chars from the String. 
    //    The String length will be at least n. 
    
    @Test
    public void testFrontAndBack() {
        //    frontAndBack("Hello", 2) -> "Helo"
        assertEquals("Helo", testMe.frontAndBack("Hello", 2));
        //    frontAndBack("Chocolate", 3) -> "Choate"
        assertEquals("Choate", testMe.frontAndBack("Chocolate", 3));
        //    frontAndBack("Chocolate", 1) -> "Ce"
        assertEquals("Ce", testMe.frontAndBack("Chocolate", 1));
    }

}