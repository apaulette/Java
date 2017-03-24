package com.sg.conditionals.test;

import com.sg.conditionals.Closer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CloserTest {
    
    Closer testMe = new Closer();
    
    public CloserTest(){
    }
    
    // Given 2 int values, return whichever value is nearest to the value 10, 
    // or return 0 in the event of a tie. 

    @Test
    public void testCloser() {
        // closer(8, 13) -> 8
        assertEquals(8, testMe.closer(8, 13));
        // closer(13, 8) -> 8
        assertEquals(8, testMe.closer(13, 8));
        // closer(13, 7) -> 0
        assertEquals(0, testMe.closer(13, 7));
    }
    
}