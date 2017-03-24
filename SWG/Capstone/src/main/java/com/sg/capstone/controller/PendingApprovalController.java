package com.sg.capstone.controller;

import com.sg.capstone.dao.BlogDao;
import com.sg.capstone.dao.StaticPageDao;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PendingApprovalController {
        
    private BlogDao dao;
    private StaticPageDao spDao;

    @Inject
    public PendingApprovalController(BlogDao dao, StaticPageDao spDao) {
        this.dao = dao;
        this.spDao = spDao;
    }
    
    @RequestMapping(value={"/pendingApproval"}, method=RequestMethod.GET)
    public String displayPendingApprovalPage(Model model) {
        model.addAttribute("blogPostLinks", dao.getAllBlogPosts_LimitedInformation());
        model.addAttribute("staticPageLinks", spDao.getAllStaticPageLinks());
        return "pendingApprovalPage";
    }
}