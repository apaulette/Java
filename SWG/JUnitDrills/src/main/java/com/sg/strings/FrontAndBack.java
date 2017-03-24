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
public class FrontAndBack {
    
    public String frontAndBack(String str, int n) {
        String result = str.substring(0, n).concat(str.substring(str.length()-n));
        return result;
    }    
}
