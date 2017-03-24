package com.sg.capstone.controller;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
        
    public LoginController() {
    }
    
    @RequestMapping(value={"/login"}, method=RequestMethod.GET)
    public String displayLoginPage() {
        return "login";
    }
}
