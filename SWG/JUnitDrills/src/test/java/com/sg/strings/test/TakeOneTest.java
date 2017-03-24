package com.sg.strings.test;

import com.sg.strings.TakeOne;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TakeOneTest {
    
    TakeOne testMe = new TakeOne();
    
    public TakeOneTest() {
    }
    // Given a String, return a String length 1 from its front, unless 
    // front is false, in which case return a String length 1 from its 
    // back. The String will be non-empty. 

    @Test
    public void test() {

        // takeOne("Hello", true) -> "H"
        assertEquals("H", testMe.takeOne("Hello", true));
        // 
        // takeOne("Hello", false) -> "o"
        assertEquals("o", testMe.takeOne("Hello", false));
        // 
        // takeOne("oh", true) -> "o"
        assertEquals("o", testMe.takeOne("oh", true));
        
    }

}