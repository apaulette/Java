package com.sg.loops.test;

import com.sg.loops.DoNotYak;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class DoNotYakTest {
    
    DoNotYak testMe = new DoNotYak();
    
    public DoNotYakTest(){
    }
    
    // Suppose the String "yak" is unlucky. Given a String, return a 
    // version where all the "yak" are removed, but the "a" can be any 
    // char. The "yak" Strings will not overlap. 

    @Test
    public void testDoNotYak() {
        // doNotYak("yakpak") -> "pak"
        assertEquals("pak", testMe.doNotYak("yakpak"));
        // doNotYak("pakyak") -> "pak"
        assertEquals("pak", testMe.doNotYak("pakyak"));
        // doNotYak("yak123ya") -> "123ya"
        assertEquals("123ya", testMe.doNotYak("yak123ya"));
        // doNotYak("123ybk123ya") -> "123ya"
        assertEquals("123123ya", testMe.doNotYak("123ybk123ya"));
    }
    
}