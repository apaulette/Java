package com.sg.strings.test;

import com.sg.strings.MultipleEndings;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MultipleEndingsTest {

    MultipleEndings testMe = new MultipleEndings();

    public MultipleEndingsTest() {
    }
    //Given a String, return a new String made of 3 copies of the last 2 chars 
    //of the original String. The String length will be at least 2. 

    @Test
    public void test() {

        //multipleEndings("Hello") -> "lololo"
        assertEquals("lololo", testMe.multipleEndings("Hello"));
        // 
        //multipleEndings("ab") -> "ababab"
        assertEquals("ababab", testMe.multipleEndings("ab"));
        // 
        //multipleEndings("Hi") -> "HiHiHi"
        assertEquals("HiHiHi", testMe.multipleEndings("Hi"));

    }

}
