package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LastDigit {
    
    public boolean lastDigit(int a, int b, int c) {
        boolean meetsCriteria = false;
        if ((a % 10 == b % 10) || (b % 10 == c % 10) || (a % 10 == c % 10)) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }
    
}