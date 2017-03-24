package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Between10And20 {
    
    public boolean between10and20(int a, int b) {
        boolean meetsCriteria = false;

        if (a >= 10 && a <= 20 || b >= 10 && b <= 20) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }
    
}
