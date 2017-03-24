package com.sg.arrays.test;

import com.sg.arrays.CommonEnd;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CommonEndTest {
    
    CommonEnd testMe = new CommonEnd();

    public CommonEndTest() {
    }
    
    // Given 2 arrays of ints, a and b, return true if they have the same 
    // first element or they have the same last element. 
    // Both arrays will be length 1 or more. 

    @Test
    public void testCommonEnd() {
       //  commonEnd({1, 2, 3}, {7, 3}) -> true
       int[] a1 = {1, 2, 3};
       int[] b1 = {7, 3};
       assertTrue(testMe.commonEnd(a1, b1));
       
       //  commonEnd({1, 2, 3}, {7, 3, 2}) -> false
       int[] a2 = {1, 2, 3};
       int[] b2 = {7, 3, 2};
       assertFalse(testMe.commonEnd(a2, b2));
       
       //  commonEnd({1, 2, 3}, {1, 3}) -> true
       int[] a3 = {1, 2, 3};
       int[] b3 = {1, 3};
       assertTrue(testMe.commonEnd(a3, b3));
    }

}