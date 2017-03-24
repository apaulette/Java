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
public class IxStart {
    
    public boolean ixStart(String str) {
        boolean meetsCriteria = false;
        
        if(str.substring(1, 3).equals("ix")) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }    
}