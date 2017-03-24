package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Closer {
    
    public int closer(int a, int b) {
        int result = 0;
        int aFrom10 = Math.abs(10 - a);
        int bFrom10 = Math.abs(10 - b);
        
        if (aFrom10 < bFrom10) {
            result = a;
        }
        if (aFrom10 > bFrom10) {
            result = b;
        }
        return result;
    }
    
}