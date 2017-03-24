package com.sg.conditionals.test;

import com.sg.conditionals.EEEEEEE;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class EEEEEEETest {
    
    EEEEEEE testMe = new EEEEEEE();
    
    public EEEEEEETest(){
    }
    
    // Return true if the given String contains between 1 and 3 'e' chars. 

    @Test
    public void testEEEEEEE() {
        // gotE("Hello") -> true
        assertTrue(testMe.gotE("Hello"));
        // gotE("Heelle") -> true
        assertTrue(testMe.gotE("Heelle"));
        // gotE("Heelele") -> false
        assertFalse(testMe.gotE("Heelele"));
    }
    
}