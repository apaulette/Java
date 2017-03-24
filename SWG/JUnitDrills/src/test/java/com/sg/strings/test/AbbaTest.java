package com.sg.strings.test;

import com.sg.strings.Abba;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AbbaTest {
    
Abba testMe = new Abba();
    
    public AbbaTest() {
    }
    
    // Given two Strings, a and b, return the result of putting them together in the 
    // order abba, e.g. "Hi" and "Bye" returns "HiByeByeHi". 

    @Test
    public void testAbba() {

        // abba("Hi", "Bye") -> "HiByeByeHi"
        assertEquals("HiByeByeHi", testMe.abba("Hi", "Bye"));

        // abba("Yo", "Alice") -> "YoAliceAliceYo"
        assertEquals("YoAliceAliceYo", testMe.abba("Yo", "Alice"));

        // abba("What", "Up") -> "WhatUpUpWhat"
        assertEquals("WhatUpUpWhat", testMe.abba("What", "Up"));

    }

}