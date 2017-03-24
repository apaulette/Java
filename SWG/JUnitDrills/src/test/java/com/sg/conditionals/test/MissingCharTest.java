package com.sg.conditionals.test;

import com.sg.conditionals.MissingChar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MissingCharTest {

    MissingChar testMe = new MissingChar();

    public MissingCharTest() {
    }
    // Given a non-empty String and an int n, return a new String where the
    // char at index n has been removed. The value of n will be a valid index
    // of a char in the original String (Don't check for bad index).

    @Test
    public void test() {
        
        // missingChar("kitten", 1) -> "ktten"
        assertEquals("ktten", testMe.missingChar("kitten", 1));

        // missingChar("kitten", 0) -> "itten"
        assertEquals("itten", testMe.missingChar("kitten", 0));

        // missingChar("kitten", 4) -> "kittn"
        assertEquals("kittn", testMe.missingChar("kitten", 4));

    }

}
