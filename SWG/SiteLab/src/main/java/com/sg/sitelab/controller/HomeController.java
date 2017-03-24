package com.sg.sitelab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
@Controller
public class HomeController {
    
    @RequestMapping(value={"/","/home"}, method=RequestMethod.GET)
    public String displayHomePage(){
        return "home";
    }
    
}