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
public class StringSplosion {

    public String stringSplosion(String str) {
        String result = "";
        int j = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.length() == 1) {
                result = str.concat(str);
                break;
            }
            if (str.length() == 2) {
                result = str.substring(0, 1).concat(str);
                break;
            }
            if (str.length() > 2) {
                if (i < str.length() - 1) {
                    result = result.concat(str.substring(0, i + 1));
                } else if (i == str.length() - 1) {
                    result = result.concat(str);
                }
            }
        }
        return result;
    }

}
