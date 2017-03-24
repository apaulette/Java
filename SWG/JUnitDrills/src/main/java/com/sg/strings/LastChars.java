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
public class LastChars {
    
    /*
    
    Given 2 Strings, a and b, return a new String made of the first char of a 
    and the last char of b, so "yo" and "java" yields "ya". If either String 
    is length 0, use '@' for its missing char. 

lastChars("last", "chars") -> "ls"
lastChars("yo", "mama") -> "ya"
lastChars("hi", "") -> "h@"    
    
    */
    
    
    public String lastChars(String a, String b) {
        String resultA = "";
        String resultB = "";
        if (a.length() == 0) {
            resultA = "@";
        } else if (a.length() == 1) {
            resultA = a;
        } else {
            resultA = a.substring(0,1);
        }
        
        if (b.length() == 0) {
            resultB = "@";
        } else if (b.length() == 1) {
            resultB = b;
        } else {
            resultB = b.substring(b.length()-1);
        }
        String result = resultA.concat(resultB);
        return result;
    }

}
