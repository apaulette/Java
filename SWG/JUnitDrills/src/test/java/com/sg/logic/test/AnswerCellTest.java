package com.sg.logic.test;

import com.sg.logic.AnswerCell;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AnswerCellTest {
    
    AnswerCell testMe = new AnswerCell();

    public AnswerCellTest() {
    }
 
    // Your cell phone rings. Return true if you should answer it. 
    // Normally you answer, except in the morning you only answer if it 
    // is your mom calling. In all cases, if you are asleep, you do not answer. 
    
    @Test
    public void testAnswerCell() {
        // answerCell(false, false, false) → true
        assertTrue(testMe.answerCell(false, false, false));
        // answerCell(false, false, true) → false
        assertFalse(testMe.answerCell(false, false, true));
        // answerCell(true, false, false) → false
        assertFalse(testMe.answerCell(true, false, false));
        // answerCell(true, true, false) → true
        // aka Mom calling in the morning
        assertTrue(testMe.answerCell(true, true, false));
    }    
    
}