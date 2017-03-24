package com.sg.strings.test;

import com.sg.strings.TweakFront;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TweakFrontTest {

    TweakFront testMe = new TweakFront();
    
    public TweakFrontTest() {
    }
    
    // Given a String, return a version without the first 2 chars. 
    // Except keep the first char if it is 'a' and keep the second char 
    // if it is 'b'. The String may be any length.

    @Test
    public void testTweakFront() {
        
        // tweakFront("Hello") -> "llo"
        assertEquals("llo", testMe.tweakFront("Hello"));
        // tweakFront("away") -> "aay"
        assertEquals("aay", testMe.tweakFront("away"));
        // tweakFront("abed") -> "abed"
        assertEquals("abed", testMe.tweakFront("abed"));
        // tweakFront("abc") -> "abc"
        assertEquals("abc", testMe.tweakFront("abc"));
        // tweakFront("acb") -> "ab"
        assertEquals("ab", testMe.tweakFront("acb"));
        // tweakFront("tie") -> "e"
        assertEquals("e", testMe.tweakFront("tie"));
    }


    
}
