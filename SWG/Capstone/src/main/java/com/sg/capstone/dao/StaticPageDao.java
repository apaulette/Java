/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.StaticPage;
import java.util.List;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public interface StaticPageDao {
    
    public void addStaticPage(StaticPage stpg);
    
    public StaticPage getStaticPageById(int staticPageId);
    
    public void updateStaticPage(StaticPage stpg);

    public void updateStaticPageDisplayOrder(StaticPage stpg);
    
    public void deleteStaticPage(int staticPageId);
    
    public void approveStaticPage(int staticPageId);
    
    public void unapproveStaticPage(int staticPageId);
    
    public List<StaticPage> getAllStaticPageLinks();
}
