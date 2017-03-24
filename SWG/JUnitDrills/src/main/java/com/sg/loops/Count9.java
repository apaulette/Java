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
public class Count9 {

    public int count9(int[] numbers) {
        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 9) {
                result++;
            }
        }
        return result;
    }

}
