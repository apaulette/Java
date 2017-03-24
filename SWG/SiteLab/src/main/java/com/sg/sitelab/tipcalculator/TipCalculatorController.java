package com.sg.sitelab.tipcalculator;

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
public class TipCalculatorController {
    
    private TipCalculatorDao dao;
    private TipCalculations calc = new TipCalculations();
    
    @Inject
    public TipCalculatorController(TipCalculatorDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/tipCalculator", method=RequestMethod.GET)
    public String displayTipCalculator() {
        return "tipCalculator";
    }
    
    @RequestMapping(value = "/runTipCalculator", method = RequestMethod.POST)
    public String runTipCalculator(HttpServletRequest req, Model model) {
        
        double checkAmount = Double.parseDouble(req.getParameter("checkAmount"));
        double tipPercent = Double.parseDouble(req.getParameter("tipPercent"));
        double tipAmount = calc.calculateTipAmount(checkAmount, tipPercent);
        double totalAmount = calc.calculateTotalAmount(checkAmount, tipAmount);
        
        TipCalculatorModel tipCalc = dao.returnTipCalc();
        dao.resetTipCalc();
        
        tipCalc.setCheckAmount(checkAmount);
        tipCalc.setTipPercent(tipPercent);
        tipCalc.setTipAmount(tipAmount);
        tipCalc.setTotalAmount(totalAmount);
        
        model.addAttribute("tipCalc", tipCalc);        
        return "tipCalculator";
    }
}
