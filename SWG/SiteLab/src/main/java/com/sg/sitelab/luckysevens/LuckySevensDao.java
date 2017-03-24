package com.sg.sitelab.luckysevens;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public interface LuckySevensDao {

    public void rollDice();
    public void evaluateRollTotal();
    public void calculateCurrentMoneyAfterRoll();
    public void evaluateMaxMoneyRoll(int rollCounter);
    public void resetRoundStats();
    public RoundStats returnRoundStats();
    
}