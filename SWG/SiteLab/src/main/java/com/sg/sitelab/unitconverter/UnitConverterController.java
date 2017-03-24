package com.sg.sitelab.unitconverter;

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
public class UnitConverterController {
    
    private Calculations calc = new Calculations();
    private UnitConverterDao dao;
    
    @Inject
    public UnitConverterController(UnitConverterDao dao) {
        this.dao = dao;
    }
    
    @RequestMapping(value="/unitConverter", method=RequestMethod.GET)
    public String displayUnitConverter() {
        return "unitConverter";
    }
    
    @RequestMapping(value="/runUnitConverter", method=RequestMethod.POST)
    public String displayUnitConverter(HttpServletRequest req, Model model) {
        
        String conversionType = req.getParameter("conversionType");
        String unitFrom = req.getParameter("unitFrom");
        String unitTo = req.getParameter("unitTo");
        double number = Double.parseDouble(req.getParameter("numberInput"));
        
        double convertedNumber = calc.routeConversionType(conversionType, unitFrom, unitTo, number);
        
        ConversionObject conversion = dao.createConversionObject();
        
        conversion.setConversionType(conversionType);
        conversion.setUnitFrom(unitFrom);
        conversion.setUnitTo(unitTo);
        conversion.setNumber(number);
        conversion.setConvertedNumber(convertedNumber);
        
        req.setAttribute("conversion", conversion);
        
        return "unitConverter";
    }    
}
