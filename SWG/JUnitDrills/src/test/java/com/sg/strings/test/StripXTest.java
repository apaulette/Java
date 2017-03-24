/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.strings.test;
import org.junit.Test;
import static org.junit.Assert.*;

import com.sg.strings.StripX;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StripXTest {
    
    StripX testMe = new StripX();
    
    public StripXTest() {
    }
    
    // Given a String, if the first or last chars are 'x', return 
    // the String without those 'x' chars, and otherwise return 
    // the String unchanged. 

    @Test
    public void testStripXTest() {
        
        // stripX("xHix") -> "Hi"
        assertEquals("Hi", testMe.stripX("xHix"));
        // stripX("xHi") -> "Hi"
        assertEquals("Hi", testMe.stripX("xHi"));
        // stripX("Hxix") -> "Hxi"        
        assertEquals("Hxi", testMe.stripX("Hxix"));
        // stripX("Hiya") -> "Hiya"        
        assertEquals("Hiya", testMe.stripX("Hiya"));
    }
    
}
