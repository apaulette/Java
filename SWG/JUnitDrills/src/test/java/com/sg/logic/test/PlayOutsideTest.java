package com.sg.logic.test;

import com.sg.logic.PlayOutside;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class PlayOutsideTest {
    
    PlayOutside testIt = new PlayOutside();

    public PlayOutsideTest() {
    }
    
//    The children in Cleveland spend most of the day playing outside. 
//    In particular, they play if the temperature is between 60 and 90 
//    (inclusive). Unless it is summer, then the upper limit is 100 
//    instead of 90. Given an int temperature and a boolean isSummer, 
//    return true if the children play and false otherwise. 
    
    
    @Test
    public void testPlayOutside() {
        
        //    playOutside(70, false) → true
        assertTrue(testIt.playOutside(70, false));
        
        //    playOutside(95, false) → false
        assertFalse(testIt.playOutside(95, false));
        
        //    playOutside(95, true) → true
        assertTrue(testIt.playOutside(95, true));

    }    
    
}
