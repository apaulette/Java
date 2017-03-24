package com.sg.sitelab.flooringcalculator;

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
public class FlooringCalculatorController {

    private FlooringCalculatorDao dao;
    private FlooringCalculations calc = new FlooringCalculations();
    
    @Inject
    public FlooringCalculatorController(FlooringCalculatorDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/flooringCalculator", method=RequestMethod.GET)
    public String displayFlooringCalculator() {
        return "flooringCalculator";
    }
    
    @RequestMapping(value="/runFlooringCalculator", method=RequestMethod.POST)
    public String runFlooringCalculator(HttpServletRequest req, Model model) {
        
        double width = calc.dimensionToInches(req.getParameter("widthFeet"), 
                req.getParameter("widthInches"));
        double length = calc.dimensionToInches(req.getParameter("lengthFeet"), 
                req.getParameter("lengthInches"));
        double costPerSqFt = Double.parseDouble(req.getParameter("costPerSqFt"));

        double area = calc.calculateArea(width, length);
        String installationTime = calc.calculateInstallationTime(area);
        int billedIncrements  = calc.calculateBilledIncrements(area);
        
        double totalMaterialCost = calc.calculateCostForArea(costPerSqFt, area);
        double totalLaborCost = calc.calculateLaborCosts(billedIncrements);
        double grandTotal = totalMaterialCost + totalLaborCost;
        
        model.addAttribute("area", area);
        model.addAttribute("totalMaterialCost", totalMaterialCost);
        model.addAttribute("installationTime", installationTime);
        model.addAttribute("billedIncrements", billedIncrements);
        model.addAttribute("totalLaborCost", totalLaborCost);
        model.addAttribute("grandTotal", grandTotal);
        
        return "flooringCalculator";
    }
    
}
