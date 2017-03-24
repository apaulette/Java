package com.sg.logic.test;

import com.sg.logic.CanHazTable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CanHazTableTest {
    
    CanHazTable testIt = new CanHazTable();

    public CanHazTableTest() {
    }
    
    // You and your date are trying to get a table at a restaurant. 
    // The parameter "you" is the stylishness of your clothes, in 
    // the range 0..10, and "date" is the stylishness of your date's 
    // clothes. The result getting the table is encoded as an int value 
    // with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 
    // 8 or more, then the result is 2 (yes). With the exception that 
    // if either of you has style of 2 or less, then the result is 0 (no). 
    // Otherwise the result is 1 (maybe). 


    
    @Test
    public void testCanHazTable() {
        
        // canHazTable(5, 10) → 2
        assertEquals(2, testIt.canHazTable(5, 10));
        
        // canHazTable(5, 2) → 0
        assertEquals(0, testIt.canHazTable(5, 2));
        
        // canHazTable(5, 5) → 1
        assertEquals(1, testIt.canHazTable(5, 5));
        

    }    
    
}
