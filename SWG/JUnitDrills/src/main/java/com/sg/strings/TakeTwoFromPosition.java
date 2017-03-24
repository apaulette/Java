/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.strings;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class TakeTwoFromPosition {
    
    public String takeTwoFromPosition(String str, int n) {
        String result = "";
        if (str.length()-n == 2) {
            result = str.substring(n);
        } else if (str.length()-n < 2) {
            result = str.substring(0, 2);
        } else {
            result = str.substring(n, n+2);
        }
        return result;
    }    
}
