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
public class SoAlone {

    public boolean soAlone(int a, int b) {
        boolean meetsCriteria = false;

        if (a >= 13 && a <= 19 && b >= 13 && b <= 19) {
            meetsCriteria = false;
        } else if (a >= 13 && a <= 19 || b >= 13 && b <= 19) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }

}
