package com.sg.conditionals.test;

import com.sg.conditionals.MischeviousChildren;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MischeviousChildrenTest {

    MischeviousChildren testIt = new MischeviousChildren();

    public MischeviousChildrenTest() {
    }
    // We have two children, a and b, and the parameters aSmile and bSmile 
    // indicate if each is smiling. We are in trouble if they are both smiling 
    // or if neither of them is smiling. Return true if we are in trouble. 

    // public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
    //  
    // }
    @Test
    public void test() {
        
        // areWeInTrouble(true, true) -> true
        assertTrue(testIt.areWeInTrouble(true, true));

        // areWeInTrouble(false, false) -> true
        assertTrue(testIt.areWeInTrouble(false, false));

        // areWeInTrouble(true, false) -> false
        assertFalse(testIt.areWeInTrouble(true, false));
        
    }

}