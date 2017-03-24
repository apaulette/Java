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
public class CountXX {

    public int countXX(String str) {
        int count = 0;
        for (int i = 0; i <= str.length()-2; i++) {
            if (str.substring(i).equalsIgnoreCase("xx")) {
                count++;
            } else if (str.substring(i, i + 2).equalsIgnoreCase("xx")) {
                count++;
            }
        }
        return count;
    }
}
