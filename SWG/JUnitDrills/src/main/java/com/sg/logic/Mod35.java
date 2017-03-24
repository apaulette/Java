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
public class Mod35 {
    
    public boolean mod35(int n) {
        boolean meetsCriteria = false;
        if (n % 3 == 0 && n % 5 == 0) {
            meetsCriteria = false;
        } else if (n % 3 == 0 || n % 5 == 0) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }
    
}