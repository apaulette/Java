/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.sitelab.interestcalculator;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class YearCalculation {
    
    private int calendarYear;
    private int termYearNumber;
    private double yearBeginningBalance;
    private double yearInterestEarned;
    private double yearEndingBalance;

    public int getCalendarYear() {
        return calendarYear;
    }

    public void setCalendarYear(int calendarYear) {
        this.calendarYear = calendarYear;
    }

    public int getTermYearNumber() {
        return termYearNumber;
    }

    public void setTermYearNumber(int termYearNumber) {
        this.termYearNumber = termYearNumber;
    }

    public double getYearBeginningBalance() {
        return yearBeginningBalance;
    }

    public void setYearBeginningBalance(double yearBeginningBalance) {
        this.yearBeginningBalance = yearBeginningBalance;
    }

    public double getYearInterestEarned() {
        return yearInterestEarned;
    }

    public void setYearInterestEarned(double yearInterestEarned) {
        this.yearInterestEarned = yearInterestEarned;
    }

    public double getYearEndingBalance() {
        return yearEndingBalance;
    }

    public void setYearEndingBalance(double yearEndingBalance) {
        this.yearEndingBalance = yearEndingBalance;
    }
    
}