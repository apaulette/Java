package com.sg.strings.test;

import com.sg.strings.RotateLeft2;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RotateLeft2Test {
    
    RotateLeft2 testMe = new RotateLeft2();


    public RotateLeft2Test() {
    }
    // Given a String, return a "rotated left 2" version where the first 
    // 2 chars are moved to the end. The String length will be at least 2. 

    @Test
    public void test() {
        
        //rotateLeft2("Hello") -> "lloHe"
        assertEquals("lloHe", testMe.rotateLeft2("Hello"));
        // 
        //rotateLeft2("java") -> "vaja"
        assertEquals("vaja", testMe.rotateLeft2("java"));
        // 
        //rotateLeft2("Hi") -> "Hi"
        assertEquals("Hi", testMe.rotateLeft2("Hi"));
        
    }

}