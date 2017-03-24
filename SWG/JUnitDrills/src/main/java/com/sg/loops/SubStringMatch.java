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
public class SubStringMatch {
    
    public int subStringMatch(String a, String b) {
        int matchCount = 0;

        int minLength = a.length();
        if (a.length() > b.length()) {
            minLength = b.length();
            a = a.substring(0, minLength);
        }
        if (a.length() < b.length()) {
            minLength = a.length();
            b = b.substring(0, minLength);
        }
        
        for (int i=0 ; i < minLength ; i++) {
            if (i < minLength - 2 && a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                matchCount += 1;
            }
            if (i == minLength - 2 && a.substring(i).equals(b.substring(i))) {
                matchCount += 1;
            }
        }

        return matchCount;
    }    
}