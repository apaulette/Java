package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Array667 {
    
    public int array667(int[] numbers) {
        int times = 0;
        
        for (int i = 0 ; i <= numbers.length - 2 ; i++) {
            if (i <= numbers.length - 2) {
                if (numbers[i] == 6 && (numbers[i + 1] == 6 || numbers[i + 1] == 7)) {
                    times += 1;
                }
            }
        }
        return times;
    }    
    
}
