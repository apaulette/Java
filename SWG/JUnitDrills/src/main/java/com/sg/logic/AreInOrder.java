/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.logic;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class AreInOrder {
    
    public boolean areInOrder(int a, int b, int c, boolean bOk) {
        boolean meetsCriteria = false;
        
        if (( b > a && c > b && !bOk) || ( c > b && bOk)) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }
    
}
