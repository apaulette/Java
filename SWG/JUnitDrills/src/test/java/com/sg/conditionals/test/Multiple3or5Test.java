package com.sg.conditionals.test;

import com.sg.conditionals.Multiple3or5;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Multiple3or5Test {
    
    Multiple3or5 testMe = new Multiple3or5();
    
    public Multiple3or5Test() {
    }
    
    // Return true if the given non-negative number is a multiple of 3 or 
    // a multiple of 5. Use the % "mod" operator

    @Test
    public void testMultiple3or5() {
        // multiple3or5(3) -> true
        assertTrue(testMe.multiple3or5(3));
        // multiple3or5(10) -> true
        assertTrue(testMe.multiple3or5(10));
        // multiple3or5(8) -> false
        assertFalse(testMe.multiple3or5(8));
    }
    
}