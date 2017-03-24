package com.sg.arrays;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class Double23 {
    
    public boolean double23(int[] numbers) {
        boolean meetsCriteria = false;
        int quant2 = 0;
        int quant3 = 0;
        
        for (int i = 0 ; i < numbers.length ; i++) {
            if (numbers[i] == 2) {
                quant2 += 1;
            }
            if (numbers[i] == 3) {
                quant3 += 1;
            }
        }
        
        if (quant2 == 2 || quant3 == 2) {
            meetsCriteria = true;
        }
        return meetsCriteria;
    }    
}
