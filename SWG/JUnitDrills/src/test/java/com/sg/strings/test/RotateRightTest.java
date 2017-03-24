package com.sg.strings.test;

import com.sg.strings.RotateRight;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RotateRightTest {
    
    RotateRight testMe = new RotateRight();


    public RotateRightTest() {
    }
    // Given a String, return a "rotated right 2" version where the last 
    // 2 chars are moved to the start. The String length will be at least 2. 

    @Test
    public void test() {

        //rotateRight2("Hello") -> "loHel"
        assertEquals("loHel", testMe.rotateRight2("Hello"));
        // 
        // rotateRight2("java") -> "vaja"
        assertEquals("vaja", testMe.rotateRight2("java"));
        // 
        // rotateRight2("Hi") -> "Hi"
        assertEquals("Hi", testMe.rotateRight2("Hi"));
        
    }

}