package com.sg.sitelab.luckysevens;

import java.util.Random;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LuckySevensDaoInMemImpl implements LuckySevensDao {
    
    private RoundStats stats;

    public LuckySevensDaoInMemImpl(){
        stats = new RoundStats();
    }
    
    
    @Override
    public void rollDice() {
        Random randNum = new Random();
        int result1 = randNum.nextInt(6) + 1;
        int result2 = randNum.nextInt(6) + 1;
        stats.setDie1(result1);
        stats.setDie2(result2);
    }
    @Override
    public void evaluateRollTotal() {
        int rollTotal = stats.getDie1() + stats.getDie2();
        stats.setRollTotal(rollTotal);
//        return rollTotal;
    }
    @Override
    public void calculateCurrentMoneyAfterRoll() {
        int rollTotal = stats.getRollTotal();
        int currentMoney = stats.getCurrentMoney();
        
        if (rollTotal == 7) {
            currentMoney += 4;
        } else {
            currentMoney -= 1;
        }
        stats.setCurrentMoney(currentMoney);
    }
    @Override
    public void evaluateMaxMoneyRoll(int rollCounter) {
        if (stats.getCurrentMoney() > stats.getMaxMoney()) {
            stats.setMaxMoney(stats.getCurrentMoney());
            stats.setMaxMoneyRoll(rollCounter + 1);
        }
    }
    
    @Override
    public void resetRoundStats() {
        stats.setWager(0);
        stats.setEndRolls(0);
        stats.setMaxMoney(0);
        stats.setMaxMoneyRoll(0);
        stats.setCurrentMoney(0);
        stats.setDie1(0);
        stats.setDie2(0);
        stats.setRollTotal(0);
    }
    
    @Override
    public RoundStats returnRoundStats() {
        return stats;
    }

}