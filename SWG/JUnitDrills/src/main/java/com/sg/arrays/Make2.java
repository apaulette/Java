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
public class Make2 {
    
    public int[] make2(int[] a, int[] b) {
        int[] result = new int[2];
        
        if (a.length == 2) {
            result[0] = a[0];
            result[1] = a[1];
        } else if (a.length == 1) {
            result[0] = a[0];
            result[1] = b[0];
        } else if (a.length == 0 || b.length >= 2) {
            result[0] = b[0];
            result[1] = b[1];
        }
        return result;
    }
    
}