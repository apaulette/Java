package com.sg.conditionals;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Max {

    public int max(int a, int b, int c) {
        int maxValue = 0;
        
        if (a > maxValue) {
            maxValue = a;
        }
        if (b > maxValue) {
            maxValue = b;
        }
        if (c > maxValue) {
            maxValue = c;
        }
        return maxValue;
    }
}