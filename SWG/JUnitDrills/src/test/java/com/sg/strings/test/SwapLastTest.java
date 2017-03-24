package com.sg.strings.test;

import com.sg.strings.SwapLast;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SwapLastTest {
    
    SwapLast testMe = new SwapLast();
    
    public SwapLastTest() {
    }
    
    // Given a String of any length, return a new String where the last
    // 2 chars, if present, are swapped, so "coding" yields "codign". 
    
    @Test
    public void testSwapLast() {
        // swapLast("coding") -> "codign"
        assertEquals("codign", testMe.swapLast("coding"));
        // swapLast("cat") -> "cta"
        assertEquals("cta", testMe.swapLast("cat"));
        // swapLast("ab") -> "ba"        
        assertEquals("ba", testMe.swapLast("ab"));
    }
    
    
    
}
