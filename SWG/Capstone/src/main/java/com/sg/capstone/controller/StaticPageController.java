/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.controller;

import com.sg.capstone.dao.BlogDao;
import com.sg.capstone.dao.CategoryDao;
import com.sg.capstone.dao.StaticPageDao;
import com.sg.capstone.dao.TagDao;
import com.sg.capstone.model.StaticPage;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */

@Controller
public class StaticPageController {
    
    private BlogDao blogDao;
    private CategoryDao catDao;
    private StaticPageDao spDao;
    private TagDao tagDao;    
    
    @Inject
    public StaticPageController(BlogDao blogDao,CategoryDao catDao, StaticPageDao spDao, TagDao tagDao) {
        this.blogDao = blogDao;
        this.catDao = catDao;
        this.spDao = spDao;
        this.tagDao = tagDao;  
    }
    
    @RequestMapping(value={"/createStaticPage"}, method=RequestMethod.GET)
    public String displayCreateStaticPage(Model model) {
        model.addAttribute("staticPageLinks", spDao.getAllStaticPageLinks());
        return "createStaticPage";
    }
    
    @RequestMapping(value={"/postStaticPage"}, method=RequestMethod.POST)
    public String postStaticPage(Model model, @ModelAttribute StaticPage stpg, @RequestParam String title) {
        stpg.setTitle(title);
        spDao.addStaticPage(stpg);
        return "redirect:pendingApproval";
    }
    
    @RequestMapping(value={"/staticPage/{staticPageId}"}, method=RequestMethod.GET)
    public String viewStaticPage(Model model, @ModelAttribute StaticPage stpg) {
        stpg = spDao.getStaticPageById(stpg.getStaticPageId());
        model.addAttribute("staticPage", stpg);
        model.addAttribute("staticPageLinks", spDao.getAllStaticPageLinks());
        setCategoriesTagsDatesStaticPages(model);
        return "staticPage";
    }    
    
    @RequestMapping(value={"/approveStaticPage","/staticPage/approveStaticPage"}, method=RequestMethod.GET)
    public String approveStaticPage(Model model, HttpServletRequest req) {
        int staticPageId = Integer.parseInt(req.getParameter("staticPageId"));
        spDao.approveStaticPage(staticPageId);
        return "redirect:/pendingApproval";
    }
    
    @RequestMapping(value={"/unapproveStaticPage","/staticPage/unapproveStaticPage"}, method=RequestMethod.GET)
    public String unapproveStaticPage(Model model, HttpServletRequest req) {
        int staticPageId = Integer.parseInt(req.getParameter("staticPageId"));
        spDao.unapproveStaticPage(staticPageId);
        return "redirect:/pendingApproval";
    }
    
    @RequestMapping(value={"/editStaticPage","/staticPage/editStaticPage"}, method=RequestMethod.GET)
    public String editStaticPage(Model model, @ModelAttribute StaticPage stpg) {
        stpg = spDao.getStaticPageById(stpg.getStaticPageId());
        model.addAttribute("staticPage", stpg);
        return "/editStaticPage";
    }
    
    @RequestMapping(value = "/updateStaticPageDisplayOrder", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStaticPageDisplayOrder(@Valid @RequestBody ArrayList<String> json) {
        for (int i=0 ; i < json.size(); i++) {
            StaticPage stpg = new StaticPage();
            int staticPageId = Integer.parseInt(json.get(i));
            stpg.setDisplayOrder(i + 1);
            stpg.setStaticPageId(staticPageId);
            spDao.updateStaticPageDisplayOrder(stpg);
        }
    }
    
    @RequestMapping(value={"/confirmEditStaticPage","/staticPage/confirmEditStaticPage"}, method=RequestMethod.POST)
    public String confirmEditStaticPage(Model model, @ModelAttribute StaticPage stpg, HttpServletRequest req) {
        int staticPageId = Integer.parseInt(req.getParameter("staticPageId"));
        stpg.setStaticPageId(staticPageId);
        spDao.updateStaticPage(stpg);
        setCategoriesTagsDatesStaticPages(model);
        model.addAttribute("blogPostLinks", blogDao.getAllBlogPosts_LimitedInformation());
        model.addAttribute("staticPageLinks", spDao.getAllStaticPageLinks());
        return "/pendingApprovalPage";
    }
    
    @RequestMapping(value={"/deleteStaticPage","/staticPage/deleteStaticPage"}, method=RequestMethod.GET)
    public String deleteStaticPage(Model model, HttpServletRequest req) {
        int staticPageId = Integer.parseInt(req.getParameter("staticPageId"));
        spDao.deleteStaticPage(staticPageId);
        return "redirect:/pendingApproval";
    }

    private void setCategoriesTagsDatesStaticPages(Model model) {
        model.addAttribute("CategoryList", catDao.getAllActiveCategories());
        model.addAttribute("tagList", tagDao.getAllTags());        
        model.addAttribute("yearMonthsMap", blogDao.getAllUniqueYearMonths());
        model.addAttribute("staticPageLinks", spDao.getAllStaticPageLinks());        
    }
    
}
