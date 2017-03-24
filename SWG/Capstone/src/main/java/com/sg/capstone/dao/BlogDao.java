/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.BlogPost;
import com.sg.capstone.model.Category;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface BlogDao {
    
    public void addBlogPost(BlogPost post);
    
    public BlogPost getBlogPostById(int blogPostId);
    
    public void updateBlogPost(BlogPost post);
    
    public void deleteBlogPost(int blogPostId);
    
    public List<BlogPost> getAllBlogPosts();
    
    public List<BlogPost> getAllApprovedBlogPosts();
    
    public List<BlogPost> getAllBlogPosts_LimitedInformation();
    
    public List<BlogPost> getAllBlogPosts_WithSummary();
    
    public List<BlogPost> getAllBlogPostsByDate(int monthInt, int year);
    
    public List<BlogPost> getAllBlogPostsByCategoryId(int categoryId);
    
    public List<BlogPost> getAllBlogPostsByTagId(int tagId);
    
    public List<BlogPost> searchBlogPostsByKeyword(String searchCriteria);
    
    public List<Integer> getAllTagIdsByBlogPostId(int blogPostId);
    
    public List<Integer> getAllCategoryIdsByBlogPostId(int blogPostId);
    
    public List<Integer> getAllUniqueYears();
    
    public Map<Integer, List<String>> getAllUniqueYearMonths();
    
    public void approveBlogPost(int blogPostId);
    
    public void unapproveBlogPost(int blogPostId);
    
}
