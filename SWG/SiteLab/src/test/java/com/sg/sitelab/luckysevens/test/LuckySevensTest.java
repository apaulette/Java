package com.sg.sitelab.luckysevens.test;

import com.sg.sitelab.luckysevens.LuckySevensDao;
import com.sg.sitelab.luckysevens.RoundStats;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class LuckySevensTest {
    
    LuckySevensDao testMe;
    
    public LuckySevensTest(){
    }
    
    @Before
    public void setUpClass() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        testMe = (LuckySevensDao) ctx.getBean("luckySevensDao");
    }
    
    @Test
    public void testRollDice() {
        RoundStats testRoundStats = testMe.returnRoundStats();
        testMe.rollDice();
        assertFalse(0 == testRoundStats.getDie1());
        assertFalse(0 == testRoundStats.getDie2());
        assertTrue(7 > testRoundStats.getDie1());
        assertTrue(7 > testRoundStats.getDie2());
    }
    
    @Test
    public void testEvaluateRollTotal() {
        RoundStats testRoundStats = testMe.returnRoundStats();
        
        // die1 = 4, die2 = 6 -> 10    
        testRoundStats.setDie1(4);
        testRoundStats.setDie2(6);
        testMe.evaluateRollTotal();
        assertEquals(10, testRoundStats.getRollTotal());
        
        // die1 = 2, die2 = 5 -> 7    
        testRoundStats.setDie1(2);
        testRoundStats.setDie2(5);
        testMe.evaluateRollTotal();        
        assertEquals(7, testRoundStats.getRollTotal());
        
        // die1 = 1, die2 = 3 -> 4  
        testRoundStats.setDie1(1);
        testRoundStats.setDie2(3);
        testMe.evaluateRollTotal();        
        assertEquals(4, testRoundStats.getRollTotal());
        
    }

    @Test
    public void testCalculateCurrentMoneyAfterRoll() {
        RoundStats testRoundStats = testMe.returnRoundStats();
        
        // Roll != 7 should result in currentMoney - 1
        testRoundStats.setRollTotal(4);
        testRoundStats.setCurrentMoney(78);
        // int currentMoney = 78 - 1;
        testMe.calculateCurrentMoneyAfterRoll();
        assertEquals(77, testRoundStats.getCurrentMoney());
        
        // Roll == 7 should result in currentMoney + 4
        testRoundStats.setRollTotal(7);
        // int currentMoney = 77 + 4;
        testMe.calculateCurrentMoneyAfterRoll();
        assertEquals(81, testRoundStats.getCurrentMoney());
    }
    
    @Test
    public void testEvaluateMaxMoneyRoll() {
        RoundStats testRoundStats = testMe.returnRoundStats();
        testRoundStats.setMaxMoney(14);
        int rollCounter = 95;

        // Next roll would be 96 and currentMoney > maxMoney set above 
        // should see maxMoney and maxMoneyRoll go up accordingly
        testRoundStats.setCurrentMoney(17);
        testMe.evaluateMaxMoneyRoll(rollCounter);
        rollCounter++;
        assertEquals(17, testRoundStats.getMaxMoney());
        assertEquals(96, testRoundStats.getMaxMoneyRoll());
        
        // Roll 97: Losing $1 should result in no change
        testRoundStats.setCurrentMoney(16);
        testMe.evaluateMaxMoneyRoll(rollCounter);
        rollCounter++;
        assertEquals(17, testRoundStats.getMaxMoney());
        assertEquals(96, testRoundStats.getMaxMoneyRoll());

        // Roll 98: Won $4 should should see maxMoney and maxMoneyRoll go up
        testRoundStats.setCurrentMoney(20);
        testMe.evaluateMaxMoneyRoll(rollCounter);
        rollCounter++;
        assertEquals(20, testRoundStats.getMaxMoney());
        assertEquals(98, testRoundStats.getMaxMoneyRoll());

    }
    
    @Test
    public void testResetRoundStats() {
        RoundStats testRoundStats = testMe.returnRoundStats();
        testRoundStats.setWager(1);
        testRoundStats.setEndRolls(2);
        testRoundStats.setMaxMoney(3);
        testRoundStats.setMaxMoneyRoll(4);
        testRoundStats.setCurrentMoney(5);
        testRoundStats.setDie1(6);
        testRoundStats.setDie2(7);
        testRoundStats.setRollTotal(8);
        
        // Test that fields have successfully set
        assertEquals("1 2 3 4 5 6 7 8", testRoundStats.toString());
        testMe.resetRoundStats();
        
        // Now test that fields have successfully reset via specified method
        assertEquals("0 0 0 0 0 0 0 0", testRoundStats.toString());
    }
    
}