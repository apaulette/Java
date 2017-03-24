/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.conditionals;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class EveryNth {
    
    public String everyNth(String str, int n) {
        String result = "";
        String[] strChars = str.split("");
        
        for (int i=0 ; i < strChars.length ; i++) {
            if (i % n == 0) {
                result = result.concat(strChars[i]);
            }
        }
        return result;
    }
    
}