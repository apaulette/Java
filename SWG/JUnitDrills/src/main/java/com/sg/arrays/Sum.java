package com.sg.arrays;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Sum {
    
    public int sum(int[] numbers) {
        int sum = 0;
        for (int i = 0 ; i < numbers.length ; i++) {
            sum += numbers[i];
        }
        return sum;
    }    
}
