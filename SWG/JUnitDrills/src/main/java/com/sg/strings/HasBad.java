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
public class HasBad {
    
    public boolean hasBad(String str) {
        boolean confirmed = false;
        if (str.length() < 3) {
            confirmed = false;
        } else if (str.length() == 3 && str.equals("bad")) {
            confirmed = true;
        } else if (str.length() == 4 && str.substring(0,3).endsWith("bad") || str.substring(1).equalsIgnoreCase("bad")) {
            confirmed = true;
        } else if (str.length() > 4 && str.substring(0,3).endsWith("bad") || str.substring(1,4).equalsIgnoreCase("bad")) {
            confirmed = true;
        }
        return confirmed;
    }    
}
