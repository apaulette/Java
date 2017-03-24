package com.sg.strings.test;

import com.sg.strings.TakeTwoFromPosition;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TakeTwoFromPositionTest {
    
TakeTwoFromPosition testMe = new TakeTwoFromPosition();
    
    public TakeTwoFromPositionTest() {
    }
    
    //    Given a String and an index, return a String length 2 
    //    starting at the given index. If the index is too big or 
    //    too small to define a String length 2, use the first 2 chars. 
    //    The String length will be at least 2. 

    
    @Test
    public void testTakeTwoFromPosition() {

        //    takeTwoFromPosition("java", 0) -> "ja"
        assertEquals("ja", testMe.takeTwoFromPosition("java", 0));
        //    takeTwoFromPosition("java", 2) -> "va"
        assertEquals("va", testMe.takeTwoFromPosition("java", 2));
        //    takeTwoFromPosition("java", 3) -> "ja"
        assertEquals("ja", testMe.takeTwoFromPosition("java", 3));
    }

}