/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.model.ops;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class MonthConverter {
    
    public static Map<String, Integer> monthToInteger;
    
    public MonthConverter() {
        monthToInteger = new HashMap<>();
        
        monthToInteger.put("JANUARY", 1);
        monthToInteger.put("FEBRUARY", 2);
        monthToInteger.put("MARCH", 3);
        monthToInteger.put("APRIL", 4);
        monthToInteger.put("MAY", 5);
        monthToInteger.put("JUNE", 6);
        monthToInteger.put("JULY", 7);
        monthToInteger.put("AUGUST", 8);
        monthToInteger.put("SEPTEMBER", 9);
        monthToInteger.put("OCTOBER", 10);
        monthToInteger.put("NOVEMBER", 11);
        monthToInteger.put("DECEMBER", 12);
    }
    
    public int getMonthInt(String MONTH) {
        return monthToInteger.get(MONTH);
    }
}
