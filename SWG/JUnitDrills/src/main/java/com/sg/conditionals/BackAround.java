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
public class BackAround {
    
    public String backAround(String str) {
        String last = str.substring(str.length()-1);
        String result = last.concat(str).concat(last);
        return result;
    }
    
}
