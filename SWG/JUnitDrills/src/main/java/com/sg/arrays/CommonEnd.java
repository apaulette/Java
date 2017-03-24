/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.arrays;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CommonEnd {
    
    public boolean commonEnd(int[] a, int[] b) {
        boolean meetsCriteria = false;
        if ((a[0] == b[0]) || (a[a.length-1] == b[b.length-1])) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }    
}
