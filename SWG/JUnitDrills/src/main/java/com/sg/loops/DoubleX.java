package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class DoubleX {

    public boolean doubleX(String str) {
        boolean doubleXConfirmed = false;
        int xCount = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 1).equals("x")) {
                xCount++;
            }
            if (xCount == 1) {
                if (str.substring(i, i + 1).equals("x")
                        && str.substring(i + 1, i + 2).equals("x")) {
                    doubleXConfirmed = true;
                } else if (str.substring(i, i + 1).equals("x")
                        && str.substring(i + 1).equals("x")) {
                    doubleXConfirmed = true;
                }
            }
        }
        return doubleXConfirmed;
    }

}
