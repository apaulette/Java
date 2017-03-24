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
public class StringTimes {

    public String stringTimes(String str, int n) {
        String output = "";
        for (int i = 0 ; i < n ; i++) {
            output = output.concat(str);
        }
        return output;
    }

}
