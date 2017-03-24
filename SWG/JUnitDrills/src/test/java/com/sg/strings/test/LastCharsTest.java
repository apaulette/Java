package com.sg.strings.test;

import com.sg.strings.LastChars;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LastCharsTest {
    
LastChars testMe = new LastChars();
    
    public LastCharsTest() {
    }
    
    //    Given 2 Strings, a and b, return a new String made of the 
    //    first char of a and the last char of b, so "yo" and "java" 
    //    yields "ya". If either String is length 0, use '@' for 
    //    its missing char. 

    @Test
    public void testLastChars() {
        //    lastChars("last", "chars") -> "ls"
        assertEquals("ls", testMe.lastChars("last", "chars"));
        //    lastChars("yo", "mama") -> "ya"
        assertEquals("ya", testMe.lastChars("yo", "mama"));
        //    lastChars("hi", "") -> "h@"
        assertEquals("h@", testMe.lastChars("hi", ""));
        //    lastChars("", "") -> "@@"
        assertEquals("@@", testMe.lastChars("", ""));
        //    lastChars("i", "Level 42") -> "i2"
        assertEquals("i2", testMe.lastChars("i", "Level 42"));
    }
}