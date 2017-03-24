package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class IcyHot {
    
    public boolean icyHot(int temp1, int temp2) {
        boolean meetsCriteria = false;
        
        if(temp1 < 0 && temp2 > 100 || temp1 > 100 && temp2 < 0) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }
    
}