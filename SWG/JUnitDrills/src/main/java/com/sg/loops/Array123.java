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
public class Array123 {
    
    public boolean array123(int[] numbers) {
        boolean meetsCrtieria = false;
        
        for (int i = 0 ; i < numbers.length - 2 ; i++) {
            if (numbers[i] == 1 && numbers[i + 1] == 2 && numbers[i + 2] == 3) {
                meetsCrtieria = true;
            }
        }
        
        return meetsCrtieria;
    }    
}
