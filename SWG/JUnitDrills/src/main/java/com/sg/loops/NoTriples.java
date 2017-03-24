package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class NoTriples {
    
    public boolean noTriples(int[] numbers) {
        boolean noTriples = true;
        
        for (int i = 0 ; i <= numbers.length-3 ; i++) {
            if (numbers[i] == numbers[i+1] && numbers[i] == numbers[i+2]) {
                noTriples = false;
            }
        }
        return noTriples;
    }    
}