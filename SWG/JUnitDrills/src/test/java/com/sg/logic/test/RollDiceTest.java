package com.sg.logic.test;

import com.sg.logic.RollDice;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RollDiceTest {
    
    RollDice testMe = new RollDice();

    public RollDiceTest() {
    }
 
    // Return the sum of two 6-sided dice rolls, each in the range 1..6. 
    // However, if noDoubles is true, if the two dice show the same value, 
    // increment one die to the next value, wrapping around to 1 
    // if its value was 6. 

    @Test
    public void testRollDice() {
        // rollDice(2, 3, true) → 5
        assertEquals(5, testMe.rollDice(2, 3, true));
        // rollDice(3, 3, true) → 7
        assertEquals(7, testMe.rollDice(3, 3, true));
        // rollDice(3, 3, false) → 6
        assertEquals(6, testMe.rollDice(3, 3, false));
        // rollDice(6, 6, true) → 7
        assertEquals(7, testMe.rollDice(6, 6, true));
    }    
}