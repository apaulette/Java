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
public class EndsWithLy {
    
    public boolean endsWithLy(String str) {
        boolean confirmed = false;
        if (str.length() == 1) {
            confirmed = false;
        } else if (str.substring(str.length() - 2).equals("ly")) {
            confirmed = true;
        }
        return confirmed;
    }      
    
}