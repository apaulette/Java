package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class SpecialEleven {

    public boolean specialEleven(int n) {

        boolean isSpecial;

        if ((n % 11 == 0) || (n - 1) % 11 == 0) {
            isSpecial = true;
        } else {
            isSpecial = false;
        }

        return isSpecial;

    }

}