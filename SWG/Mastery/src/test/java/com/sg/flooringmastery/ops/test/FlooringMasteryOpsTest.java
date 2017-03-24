package com.sg.flooringmastery.ops.test;

import com.sg.flooringmastery.ops.Calculations;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class FlooringMasteryOpsTest {

    Calculations testCalc = new Calculations();
    
    public FlooringMasteryOpsTest() {
    }
    
    @Test
    public void testCalculateMaterialCost() {
        // area ->                  225
        // materialCostPerSqFoot -> 1.5
        // Expected ->              337.5
        assertEquals(337.5, testCalc.calculateMaterialCost(225, 1.50), 0.0000000001);
        // area ->                  180.667
        // materialCostPerSqFoot -> 2.45
        // Expected ->              442.63
        assertEquals(442.63, testCalc.calculateMaterialCost(180.667, 2.45), 0.0000000001);
        // area ->                  125
        // materialCostPerSqFoot -> 4.39
        // Expected ->              548.75
        assertEquals(337.5, testCalc.calculateMaterialCost(225, 1.50), 0.0000000001);
    }
    
    @Test
    public void testCalculateLaborCost() {
        // area ->                  167
        // laborCostPerSqFoot ->    6.86
        // Expected ->              1145.62
        assertEquals(1145.62, testCalc.calculateLaborCost(167, 6.86), 0.0000000001);
        // area ->                  212.5
        // laborCostPerSqFoot ->    2.90
        // Expected ->              616.25
        assertEquals(616.25, testCalc.calculateLaborCost(212.5, 2.90), 0.0000000001);
        // area ->                  182
        // laborCostPerSqFoot ->    3.47
        // Expected ->              631.54
        assertEquals(631.54, testCalc.calculateLaborCost(182, 3.47), 0.0000000001);
    }
    
    @Test
    public void testCalculateTaxRate() {
        // materialCost ->  337.5
        // laborCost ->     616.25
        // taxRate ->       5.30
        // Expected ->      50.55
        assertEquals(50.55, testCalc.calculateTax(337.5, 616.25, 5.30), 0.0000000001);
        // materialCost ->  442.63
        // laborCost ->     631.54
        // taxRate ->       5.75
        // Expected ->      61.76
        assertEquals(61.76, testCalc.calculateTax(442.63, 631.54, 5.75), 0.0000000001);
        // materialCost ->  548.75
        // laborCost ->     1145.62
        // taxRate ->       6.45
        // Expected ->      109.29
        assertEquals(109.29, testCalc.calculateTax(548.75, 1145.62, 6.45), 0.0000000001);
    }

    @Test
    public void testCalculateTotalCost() {
        // materialCost ->  337.5
        // laborCost ->     616.25
        // tax ->           50.55
        // Expected ->      1004.30
        assertEquals(1004.30, testCalc.calculateTotalCost(337.5, 616.25, 50.55), 0.0000000001);
        // materialCost ->  442.63
        // laborCost ->     631.54
        // tax ->           61.76
        // Expected ->      1135.93
        assertEquals(1135.93, testCalc.calculateTotalCost(442.63, 631.54, 61.76), 0.0000000001);
        // materialCost ->  548.75
        // laborCost ->     1145.62
        // tax ->           109.29
        // Expected ->      1803.66
        assertEquals(1803.66, testCalc.calculateTotalCost(548.75, 1145.62, 109.29), 0.0000000001);
    }
    
}
