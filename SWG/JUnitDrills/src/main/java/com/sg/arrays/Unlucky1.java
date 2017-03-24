package com.sg.arrays;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Unlucky1 {

    // We'll say that a 1 immediately followed by a 3 in an array is an
    // "unlucky" 1. Return true if the given array contains an unlucky 1 
    // in the first 2 or last 2 positions in the array. 
    public boolean unlucky1(int[] numbers) {
        boolean meetsCriteria = false;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers.length > 3) {
                if ((numbers[i] == 1 && numbers[i + 1] == 3) || 
                    (numbers[i + 1] == 1 && numbers[i + 2] == 3) || 
                    (numbers[numbers.length - 2] == 1 && numbers[numbers.length - 1] == 3)) {
                    meetsCriteria = true;
                }
            } else if (numbers.length == 3){
                if ((numbers[0] == 1 && numbers[1] == 3) || 
                    (numbers[1] == 1 && numbers[2] == 3)) {
                    meetsCriteria = true;
                }
            }
        }
        return meetsCriteria;
    }
}