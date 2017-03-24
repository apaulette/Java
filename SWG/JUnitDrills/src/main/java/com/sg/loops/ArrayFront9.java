/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.loops;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class ArrayFront9 {
    
    public boolean arrayFront9(int[] numbers) {
        boolean result = false;
        
        for (int i = 0 ; i < numbers.length ; i++) {
            if (numbers.length < 4 ) {
                if (numbers[i] == 9) {
                    result = true;
                }
            } else {
                if (numbers[i] == 9 && i < 4) {
                    result = true;
                }
            }
        }
        return result;
    }

}
