/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrays;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FirstLast6 {

    public boolean firstLast6(int[] numbers) {
        boolean result = false;
        if (numbers[0] == 6 || numbers[numbers.length - 1] == 6) {
            result = true;
        }
        return result;
    }

}
