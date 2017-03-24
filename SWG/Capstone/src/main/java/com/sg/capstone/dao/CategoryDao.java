/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.Category;
import com.sg.capstone.model.Tag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface CategoryDao {
    
    public boolean addCategory(Category category);
        
    public void deleteCategory(int categoryId);
    
    public List<Category> getAllCategories();
    
    public Category getCategoryById(int categoryId);
    
    public List<Category> addCategoriesFromString(String categoryString);
    
    public List<Category> getAllActiveCategories();
}
