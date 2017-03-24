package com.sg.loops.test;

import com.sg.loops.SubStringMatch;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SubStringMatchTest {
    
    SubStringMatch testMe = new SubStringMatch();
    
    public SubStringMatchTest(){
    }
    
    // Given 2 Strings, a and b, return the number of the positions where 
    // they contain the same length 2 subString. So "xxcaazz" and "xxbaaz" 
    // yields 3, since the "xx", "aa", and "az" subStrings appear in the 
    // same place in both Strings. 

    @Test
    public void testSubStringMatch() {
        // subStringMatch("xxcaazz", "xxbaaz") -> 3
        assertEquals(3, testMe.subStringMatch("xxcaazz", "xxbaaz"));
        // subStringMatch("abc", "abc") -> 2
        assertEquals(2, testMe.subStringMatch("abc", "abc"));
        // subStringMatch("abc", "axc") -> 0
        assertEquals(0, testMe.subStringMatch("abc", "axc"));
        
    }
    
}