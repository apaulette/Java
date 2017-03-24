package com.sg.arrays;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Fix23 {
    
    public int[] fix23(int[] numbers) {
        for (int i = 0 ; i < numbers.length - 1 ; i++) {
            if (numbers[i] == 2 && numbers[i + 1] == 3) {
                numbers[i + 1] = 0;
            }
        }
        
        return numbers;
    }    
}
