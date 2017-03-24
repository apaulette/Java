package com.sg.loops.test;

import com.sg.loops.CountLast2;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CountLast2Test {

    CountLast2 testIt = new CountLast2();

    public CountLast2Test() {
    }

    /*
    Given a String, return the count of the number of times that a 
    subString length 2 appears in the String and also as the last 2 
    chars of the String, so "hixxxhi" yields 1 (we won't count the end subString). 
    */
    
    @Test
    public void testCountLast2() {
        // countLast2("hixxhi") -> 1
        assertEquals(1, testIt.countLast2("hixxhi"));
        // countLast2("xaxxaxaxx") -> 1
        assertEquals(1, testIt.countLast2("xaxxaxaxx"));
        // countLast2("axxxaaxx") -> 2
        assertEquals(2, testIt.countLast2("axxxaaxx"));
    }

}
