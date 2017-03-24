/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.ops.tests;

import com.sg.capstone.model.ops.MonthConverter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class MonthConverterTests {
    
    MonthConverter monthConverter = new MonthConverter();
    
    public MonthConverterTests() {        
    }
    
    @Test
    public void testMonthConverter() {
        assertEquals(1, monthConverter.getMonthInt("JANUARY"));
        assertEquals(2, monthConverter.getMonthInt("FEBRUARY"));
        assertEquals(3, monthConverter.getMonthInt("MARCH"));
        assertEquals(4, monthConverter.getMonthInt("APRIL"));
        assertEquals(5, monthConverter.getMonthInt("MAY"));
        assertEquals(6, monthConverter.getMonthInt("JUNE"));
        assertEquals(7, monthConverter.getMonthInt("JULY"));
        assertEquals(8, monthConverter.getMonthInt("AUGUST"));
        assertEquals(9, monthConverter.getMonthInt("SEPTEMBER"));
        assertEquals(10, monthConverter.getMonthInt("OCTOBER"));
        assertEquals(11, monthConverter.getMonthInt("NOVEMBER"));
        assertEquals(12, monthConverter.getMonthInt("DECEMBER"));
    }
    
}
