package com.sg.arrays;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class KeepLast {
    
    public int[] keepLast(int[] numbers) {
        int[] newArray = new int[numbers.length * 2];
        
        newArray[newArray.length - 1] = numbers[numbers.length - 1];
        return newArray;        
    }    
}
