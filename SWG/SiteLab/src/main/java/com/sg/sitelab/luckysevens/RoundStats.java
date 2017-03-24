package com.sg.sitelab.luckysevens;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class RoundStats {
    
    private int wager;
    private int endRolls;
    private int maxMoney;
    private int maxMoneyRoll;
    private int currentMoney;
    private int die1;
    private int die2;
    private int rollTotal;

    public int getWager() {
        return wager;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }

    public int getEndRolls() {
        return endRolls;
    }

    public void setEndRolls(int endRolls) {
        this.endRolls = endRolls;
    }

    public int getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(int maxMoney) {
        this.maxMoney = maxMoney;
    }

    public int getMaxMoneyRoll() {
        return maxMoneyRoll;
    }

    public void setMaxMoneyRoll(int maxMoneyRoll) {
        this.maxMoneyRoll = maxMoneyRoll;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getDie1() {
        return die1;
    }

    public void setDie1(int die1) {
        this.die1 = die1;
    }

    public int getDie2() {
        return die2;
    }

    public void setDie2(int die2) {
        this.die2 = die2;
    }

    public int getRollTotal() {
        return rollTotal;
    }

    public void setRollTotal(int rollTotal) {
        this.rollTotal = rollTotal;
    }


    

    @Override
    public String toString(){
        String result = String.valueOf(this.wager) + " " + 
                        String.valueOf(this.endRolls) +  " " + 
                        String.valueOf(this.maxMoney) +  " " + 
                        String.valueOf(this.maxMoneyRoll) +  " " + 
                        String.valueOf(this.currentMoney) +  " " + 
                        String.valueOf(this.die1) +  " " + 
                        String.valueOf(this.die2) +  " "  + 
                        String.valueOf(this.rollTotal);
        return result;
    }
    
}