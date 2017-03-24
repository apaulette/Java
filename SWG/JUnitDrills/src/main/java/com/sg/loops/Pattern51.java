package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Pattern51 {
    
    public boolean pattern51(int[] numbers) {
        boolean matchesPattern = false;
        
        for (int i = 0 ; i <= numbers.length-3 ; i++) {
            if (numbers[i+1] == numbers[i] + 5 && numbers[i+2] == numbers[i] -1) {
                matchesPattern = true;
            }
        }
        return matchesPattern;
    }    
}
