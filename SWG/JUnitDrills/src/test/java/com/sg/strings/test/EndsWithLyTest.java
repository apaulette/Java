package com.sg.strings.test;

import com.sg.strings.EndsWithLy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class EndsWithLyTest {
    
EndsWithLy testMe = new EndsWithLy();
    
    public EndsWithLyTest() {
    }
    
    //    Given a String, return true if it ends in "ly". 
    
    @Test
    public void testEndsWithLy() {
        //    endsWithLy("oddly") -> true
        assertTrue(testMe.endsWithLy("oddly"));
        //    endsWithLy("y") -> false
        assertFalse(testMe.endsWithLy("y"));
        //    endsWithLy("oddy") -> false
        assertFalse(testMe.endsWithLy("oddy"));
    }
    
}
