package com.sg.logic.test;

import com.sg.logic.SkipSum;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SkipSumTest {
    
    SkipSum testIt = new SkipSum();

    public SkipSumTest() {
    }

    //    Given 2 ints, a and b, return their sum. However, sums in 
    //    the range 10..19 inclusive are forbidden, so in that 
    //    case just return 20. 

    @Test
    public void testSkipSum() {
        
        // skipSum(3, 4) → 7
        assertEquals(7, testIt.skipSum(3, 4));
        
        // skipSum(9, 4) → 20
        assertEquals(20, testIt.skipSum(9, 4));
        
        // skipSum(10, 11) → 21    
        assertEquals(21, testIt.skipSum(10, 11));

    }    
    
}
