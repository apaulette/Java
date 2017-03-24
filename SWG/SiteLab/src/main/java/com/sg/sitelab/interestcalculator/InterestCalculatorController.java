package com.sg.sitelab.interestcalculator;

import java.util.ArrayList;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
@Controller
public class InterestCalculatorController {
    
    private InterestCalculatorDao dao;
    private InterestCalculations calc = new InterestCalculations();

    @Inject
    public InterestCalculatorController(InterestCalculatorDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/interestCalculator", method=RequestMethod.GET)
    public String displayInterestCalculator() {
        return "interestCalculator";
    }
    
    @RequestMapping(value = "/runInterestCalculator", method = RequestMethod.POST)
    public String runInterestCalculator(HttpServletRequest req, Model model) {
        
        double initialInvestment = Double.parseDouble(req.getParameter("initialInvestment"));
        double interestRate = Double.parseDouble(req.getParameter("interestRate"));
        int calendarStartYear = Integer.parseInt(req.getParameter("calendarStartYear"));
        int yearDuration = Integer.parseInt(req.getParameter("yearDuration"));
        String compoundFrequencyString = req.getParameter("compoundFrequency");
        double compoundFrequency = dao.selectCompoundFrequency(compoundFrequencyString);
        
        int yearCounter = 1;
        int calendarYear = calendarStartYear;
        
        ArrayList<YearCalculation> calcResults = dao.returnCalcResults();
        calcResults.clear();
        
        while (yearCounter <= yearDuration) {
            double yearBeginningBalance = initialInvestment;
            
            YearCalculation newYearCalc = new YearCalculation();
            // Set calculation object fields #1-3
            newYearCalc.setCalendarYear(calendarYear);
            newYearCalc.setTermYearNumber(yearCounter);
            newYearCalc.setYearBeginningBalance(yearBeginningBalance);
            
            // Calculate and set #4
            double yearEndingBalance = calc.calculateYearEndingBalance(initialInvestment, 
                    compoundFrequency, interestRate);
            newYearCalc.setYearEndingBalance(yearEndingBalance);
            
            // Calculate and set #5
            double yearInterestEarned = calc.calculateYearInterestEarned(yearEndingBalance, 
                    yearBeginningBalance);
            newYearCalc.setYearInterestEarned(yearInterestEarned);
            // Add the calculation object to the array list
            
            calcResults.add(calcResults.size(), newYearCalc);
            
            // Update variables for next iteration
            yearCounter++;
            calendarYear++;
            initialInvestment = yearEndingBalance;
        }
        
        model.addAttribute("calcResults", calcResults);
        return "interestCalculator";
    }  
    
}