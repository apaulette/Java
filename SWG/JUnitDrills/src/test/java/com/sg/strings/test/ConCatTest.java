package com.sg.strings.test;

import com.sg.strings.ConCat;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ConCatTest {

    ConCat testMe = new ConCat();

    public ConCatTest() {
    }

    // Given two Strings, append them together (known as "concatenation")
    // and return the result. However, if the concatenation creates 
    // double-char, then omit one of the chars, so "abc" and "cat" yields "abcat". 
    
    @Test
    public void testConCat() {
        // conCat("abc", "cat") -> "abcat"
        assertEquals("abcat", testMe.conCat("abc", "cat"));
        // conCat("dog", "cat") -> "dogcat"
        assertEquals("dogcat", testMe.conCat("dog", "cat"));
        // conCat("abc", "") -> "abc"
        assertEquals("abc", testMe.conCat("abc", ""));
        // conCat("red", "dog") -> "redog"
        assertEquals("redog", testMe.conCat("red", "dog"));

    }

}
