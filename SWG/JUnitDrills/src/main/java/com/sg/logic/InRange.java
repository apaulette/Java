package com.sg.logic;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class InRange {

    public boolean inRange(int n, boolean outsideMode) {

        
    // Given a number n, return true if n is in the range 1..10, 
    // inclusive. Unless "outsideMode" is true, in which case 
    // return true if the number is less or equal to 1, or greater 
    // or equal to 10. 

        
        boolean isInRange;

        if (n >= 1 && n <=10 && !outsideMode) {
            isInRange = true;
        } else if (n <= 1 || n >= 10 && outsideMode) {
            isInRange = true;
        } else {
            isInRange = false;
        }

        return isInRange;

    }

}
