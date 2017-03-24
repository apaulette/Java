package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AnswerCell {
    
    public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
            boolean answerCell = false;
            if (isAsleep || (isMorning && !isMom)) {
                answerCell = false;
            } else if (!isMorning || !isAsleep || (isMom && isMorning)) {
                answerCell = true;
            }
            return answerCell;  
    }
}