package com.sg.conditionals;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Multiple3or5 {
    
    public boolean multiple3or5(int number) {
        boolean meetsCriteria = false;
        
        if (number % 3 == 0 || number % 5 == 0) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }
    
}