package com.sg.loops.test;

import com.sg.loops.CountXX;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CountXXTest {

    CountXX testIt = new CountXX();

    public CountXXTest() {
    }

    //    Count the number of "xx" in the given String. We'll say that 
    //    overlapping is allowed, so "xxx" contains 2 "xx". 
    
    @Test
    public void test() {
        // countXX("abcxx") -> 1
        assertEquals(1, testIt.countXX("abcxx"));
        // countXX("xxx") -> 2
        assertEquals(2, testIt.countXX("xxx"));
        // countXX("xxxx") -> 3        
        assertEquals(3, testIt.countXX("xxxx"));
    }

}
