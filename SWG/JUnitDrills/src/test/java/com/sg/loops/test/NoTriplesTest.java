package com.sg.loops.test;

import com.sg.loops.NoTriples;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class NoTriplesTest {
    
    NoTriples testMe = new NoTriples();
    
    public NoTriplesTest(){
    }
    
    // Given an array of ints, we'll say that a triple is a value appearing 
    // 3 times in a row in the array. Return true if the array does not 
    // contain any triples. 

    @Test
    public void testNoTriples() {
        // noTriples({1, 1, 2, 2, 1}) -> true
        assertTrue(testMe.noTriples(new int[] {1, 1, 2, 2, 1}));
        // noTriples({1, 1, 2, 2, 2, 1}) -> false
        assertFalse(testMe.noTriples(new int[] {1, 1, 2, 2, 2, 1}));
        // noTriples({1, 1, 1, 2, 2, 2, 1}) -> false
        assertFalse(testMe.noTriples(new int[] {1, 1, 1, 2, 2, 2, 1}));
    }
    
}