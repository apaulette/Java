package com.sg.sitelab.factorizer;

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
public class FactorizerController {
    
    private FactorizerDao dao;

    @Inject
    public FactorizerController(FactorizerDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/factorizer", method=RequestMethod.GET)
    public String displayFactorizer() {
        return "factorizer";
    }
    
    @RequestMapping(value = "/runFactorizer", method = RequestMethod.POST)
    public String runFactorizer(HttpServletRequest req, Model model) {
        
        ArrayList<Integer> factors = new ArrayList<>();
        int chosenNumber = Integer.parseInt(req.getParameter("number"));
        
        dao.calculateFactors(factors, chosenNumber);
        String perfectEvaluation = dao.evaluateIfPerfect(factors, chosenNumber);
        String primeEvaluation = dao.evaluateIfPrime(factors, chosenNumber);
        
        model.addAttribute("isPerfect", perfectEvaluation);
        model.addAttribute("isPrime", primeEvaluation);
        model.addAttribute("factors", factors);
        return "factorizer";
    }
            
}