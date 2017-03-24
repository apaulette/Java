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
public class EndUp {
    
    public String endUp(String str) {
        String result = "";
        if (str.length() <= 3) {
            result = str.toUpperCase();
        } else {
            result = str.substring(0, str.length()-3).concat(str.substring(str.length()-3).toUpperCase());
        }
        return result;
    }
    
}