package com.sg.loops;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class CountLast2 {

    public int countLast2(String str) {
        int count = 0;

        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 2).equals(str.substring(str.length() - 2))) {
                count++;
            }
        }
        return count;
    }

}
