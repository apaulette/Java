package com.sg.arrays;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class HasEven {
    
    public boolean hasEven(int[] numbers) {
        boolean meetsCriteria = false;
        
        for (int i = 0 ; i < numbers.length ; i++) {
            if (numbers[i] % 2 == 0) {
                meetsCriteria = true;
            }
        }
        return meetsCriteria;
    }
}
