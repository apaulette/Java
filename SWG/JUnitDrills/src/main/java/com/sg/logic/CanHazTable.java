package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CanHazTable {
    
    public int canHazTable(int yourStyle, int dateStyle) {
        
        int result;
        
        if (yourStyle >= 8 || dateStyle >= 8) {
            result = 2;
        } else if (yourStyle <= 2 || dateStyle <= 2) {
            result = 0;
        } else {
            result = 1;
        }
        
        return result;
    }

}
