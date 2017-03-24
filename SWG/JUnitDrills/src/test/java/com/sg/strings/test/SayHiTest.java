package com.sg.strings.test;

import com.sg.strings.SayHi;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SayHiTest {

    SayHi testMe = new SayHi();

    public SayHiTest() {
    }

    // Given a String name, e.g. "Bob", return a greeting of the form "Hello Bob!".
    
    @Test
    public void testSayHi() {

        // sayHi("Bob") -> "Hello Bob!"
        assertEquals("Hello Bob!", testMe.sayHi("Bob"));

        // sayHi("Alice") -> "Hello Alice!"
        assertEquals("Hello Alice!", testMe.sayHi("Alice"));

        // sayHi("X") -> "Hello X!"
        assertEquals("Hello X!", testMe.sayHi("X"));

    }

}