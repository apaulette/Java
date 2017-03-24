package com.sg.loops.test;

import com.sg.loops.EveryOther;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class EveryOtherTest {

    EveryOther testIt = new EveryOther();

    public EveryOtherTest() {
    }

    /*
    Given a String, return a new String made of every other char 
    starting with the first, so "Hello" yields "Hlo". 
     */
    
    @Test
    public void testEveryOther() {

        //    everyOther("Hello") -> "Hlo"
        assertEquals("Hlo", testIt.everyOther("Hello"));
        //    everyOther("Hi") -> "H"
        assertEquals("H", testIt.everyOther("Hi"));
        //    everyOther("Heeololeo") -> "Hello"
        assertEquals("Hello", testIt.everyOther("Heeololeo"));
    }

}
