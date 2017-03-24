package com.sg.conditionals.test;

import com.sg.conditionals.StartOz;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StartOzTest {

    StartOz testMe = new StartOz();

    public StartOzTest() {
    }

    // Given a String, return a String made of the first 2 chars 
    // (if present), however include first char only if it is 'o' 
    // and include the second only if it is 'z', so "ozymandias" yields "oz". 

    @Test
    public void testStartOz() {
        // startOz("ozymandias") -> "oz"
        assertEquals("oz", testMe.startOz("ozymandias"));
        // startOz("bzoo") -> "z"
        assertEquals("z", testMe.startOz("bzoo"));
        // startOz("oxx") -> "o"
        assertEquals("o", testMe.startOz("oxx"));
        // startOz("baseball") -> ""
        assertEquals("", testMe.startOz("baseball"));
    }

}