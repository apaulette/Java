package com.sg.arrays;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class MakePi {
    
    public int[] makePi(int n) {
        int[] result = new int[n];
        String piString = String.valueOf(Math.PI).replace(".", "");
        for (int i = 0; i < n; i++) {
            if (i == 15) {
                result[i] = Integer.parseInt(piString.substring(i));
            } else {
                result[i] = Integer.parseInt(piString.substring(i, i + 1));
            }
        }
        return result;
    }
    
}
