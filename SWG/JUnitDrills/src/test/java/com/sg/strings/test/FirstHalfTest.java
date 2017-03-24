package com.sg.strings.test;

import com.sg.strings.FirstHalf;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FirstHalfTest {

    FirstHalf testMe = new FirstHalf();

    public FirstHalfTest() {
    }
    //Given a String of even length, return the first half.
    //So the String "WooHoo" yields "Woo". 

    @Test
    public void test() {

        //firstHalf("WooHoo") -> "Woo"
        assertEquals("Woo", testMe.firstHalf("WooHoo"));
        //
        //firstHalf("HelloThere") -> "Hello"
        assertEquals("Hello", testMe.firstHalf("HelloThere"));
        //
        //firstHalf("abcdef") -> "abc"  
        assertEquals("abc", testMe.firstHalf("abcdef"));

    }

}
