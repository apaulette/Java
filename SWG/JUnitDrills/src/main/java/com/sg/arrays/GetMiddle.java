package com.sg.arrays;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class GetMiddle {
    
    // Given 2 int arrays, a and b, each length 3, return a new array 
    // length 2 containing their middle elements. 

        // getMiddle({1, 2, 3}, {4, 5, 6}) -> {2, 5}
        // getMiddle({7, 7, 7}, {3, 8, 0}) -> {7, 8}
        // getMiddle({5, 2, 9}, {1, 4, 5}) -> {2, 4}

    public int[] getMiddle(int[] a, int[] b) {
        
        int[] newArray = new int[]{a[1], b[1]};
        return newArray;
    }

}
