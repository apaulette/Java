package com.sg.arrays;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RotateLeft {
    
    public int[] rotateLeft(int[] numbers) {
        int[] rotatedArray = new int[numbers.length];

        for (int i=0 ; i < numbers.length ; i++) {
            if (i == 0) {
                rotatedArray[numbers.length - 1] = numbers[i];
            } else {
                rotatedArray[i-1] = numbers[i];
            }
        }
        return rotatedArray;
    }    
}
