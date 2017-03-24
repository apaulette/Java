package com.sg.logic;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RollDice {
    
    public int rollDice(int die1, int die2, boolean noDoubles) {
        if (noDoubles) {
            if (die1 == die2 && die1 < 6) {
                die1 += 1;
            } else if (die1 == die2 && die1 == 6) {
                die1 = 1;
            }
        }
        int rollTotal = die1 + die2;
        return rollTotal;
    }    
}
