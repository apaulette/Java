package com.sg.arrays;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SameFirstLast {
    

    public boolean sameFirstLast(int[] numbers) {
        boolean result = false;
        if (numbers.length >= 1 && numbers[0] == numbers[numbers.length - 1]) {
            result = true;
        }
        return result;
    }
    
}