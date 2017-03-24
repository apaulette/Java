package com.sg.loops.test;

import com.sg.loops.AltPairs;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AltPairsTest {
    
    AltPairs testMe = new AltPairs();
    
    public AltPairsTest(){
    }
    
    // Given a String, return a String made of the chars at indexes 
    // 0,1, 4,5, 8,9 ... so "kittens" yields "kien". 


    @Test
    public void testAltPairs() {
        // altPairs("kitten") -> "kien"
        assertEquals("kien", testMe.altPairs("kitten"));
        // altPairs("Chocolate") -> "Chole"
        assertEquals("Chole", testMe.altPairs("Chocolate"));
        // altPairs("CodingHorror") -> "Congrr"        
        assertEquals("Congrr", testMe.altPairs("CodingHorror"));
    }
    
}