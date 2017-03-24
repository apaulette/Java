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
import com.sg.capstone.model.BlogPost;
import com.sg.capstone.model.Category;
import com.sg.capstone.model.Tag;
import com.sg.capstone.model.ops.ListOps;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author apprentice
 */
@Controller
public class BlogPostController {

    private BlogDao dao;
    private StaticPageDao spDao;
    private TagDao tagDao;
    private CategoryDao catDao;

    @Inject
    public BlogPostController(BlogDao dao, StaticPageDao spDao, TagDao tagDao, CategoryDao catDao) {
        this.dao = dao;
        this.spDao = spDao;
        this.tagDao = tagDao;
        this.catDao = catDao;
    }

    @RequestMapping(value = {"/displayCreateBlogPost"}, method = RequestMethod.GET)
    public String displayCreateBlogPost(Map<String, Object> model) {
        return "displayCreateBlogPost";
    }

    @RequestMapping(value = {"/createBlogPost"}, method = RequestMethod.POST)
    public String createBlogPost(Model model, @ModelAttribute BlogPost blogPost, @RequestParam String tagString
                                    , @RequestParam String categoryString) {
        model.addAttribute("categoryString", categoryString);
        model.addAttribute("tagString", tagString);
        model.addAttribute("previewPost", blogPost);
        return "displayPreviewBlogPost";
    }

    @RequestMapping(value = {"/confirmBlogPost"}, method = RequestMethod.POST)
    public String confirmBlogPost(HttpServletRequest req, Model model, @ModelAttribute BlogPost blogPost, @RequestParam String title
                                    , @RequestParam String tagString, @RequestParam String categoryString) {
        blogPost.setTitle(title);
        ArrayList<Tag> tagList = (ArrayList<Tag>) tagDao.addTagsFromString(tagString);
        blogPost.setTagIds((ArrayList<Integer>) ListOps.createTagIdListFromTagList(tagList));
        ArrayList<Category> categoryList = (ArrayList<Category>) catDao.addCategoriesFromString(categoryString);
        blogPost.setCategoryIds((ArrayList<Integer>) ListOps.createCategoryIdListFromCategoryList(categoryList));
        dao.addBlogPost(blogPost);
 
        setCategoriesTagsDatesStaticPages(model);        
        
        List<BlogPost> blogPostList = dao.getAllApprovedBlogPosts();
        model.addAttribute("numberOfPages", calculateNumberOfPages(blogPostList, 5));
        
        int currentPage = setCurrentPage(req, model);
        model.addAttribute("totalBlogPostCount", blogPostList.size());
        model.addAttribute("blogPostList", displayPostsPerPage(blogPostList, currentPage, 5));
        
        model.addAttribute("endpoint", "home");

        return "home";
    }

    @RequestMapping(value = {"/displaySubmittedBlogPost/{blogPostId}"}, method = RequestMethod.GET)
    public String confirmBlogPost(Model model, @ModelAttribute BlogPost blogPost) {
        blogPost = dao.getBlogPostById(blogPost.getBlogPostId());
        List<Integer> blogPostTagIds = dao.getAllTagIdsByBlogPostId(blogPost.getBlogPostId());
        List<Tag> blogPostTags = new ArrayList<>();
        for (int tagId : blogPostTagIds) {
            blogPostTags.add(tagDao.getTagById(tagId));
        }
        
        List<Integer> blogPostCategoryIds = dao.getAllCategoryIdsByBlogPostId(blogPost.getBlogPostId());
        List<Category> blogPostCategories = new ArrayList<>();
        for (int categoryId : blogPostCategoryIds) {
            blogPostCategories.add(catDao.getCategoryById(categoryId));
        }
        model.addAttribute("tags", blogPostTags);
        model.addAttribute("categories", blogPostCategories);
        model.addAttribute("blogPost", blogPost);
        model.addAttribute("staticPageLinks", spDao.getAllStaticPageLinks());
        setCategoriesTagsDatesStaticPages(model);
        return "displaySubmittedBlogPost";
    }

    @RequestMapping(value = {"/deleteSubmittedBlogPost"}, method = RequestMethod.GET)
    public String deleteBlogPost(Model model, HttpServletRequest req) {
        int blogPostId = Integer.parseInt(req.getParameter("blogPostId"));
        dao.deleteBlogPost(blogPostId);

        List<BlogPost> blogPostList = dao.getAllBlogPosts_WithSummary();
        model.addAttribute("numberOfPages", calculateNumberOfPages(blogPostList, 5));
        
        int currentPage = setCurrentPage(req, model);
        model.addAttribute("totalBlogPostCount", blogPostList.size());
        model.addAttribute("blogPostList", displayPostsPerPage(blogPostList, currentPage, 5));
        
        model.addAttribute("endpoint", "home");
        setCategoriesTagsDatesStaticPages(model);
        return "home";
    }

    @RequestMapping(value = {"/displayEditBlogPost","/displaySubmittedBlogPost/displayEditBlogPost"}, method = RequestMethod.GET)
    public String displayEditBlogPost(Model model, @ModelAttribute BlogPost blogPost) {
        blogPost = dao.getBlogPostById(blogPost.getBlogPostId());
        List<String> categoryNameList = new ArrayList<>();
        List<Integer> categoryIdList = dao.getAllCategoryIdsByBlogPostId(blogPost.getBlogPostId());
        blogPost.setCategoryIds((ArrayList) categoryIdList);
        for (Integer i : categoryIdList) {
            categoryNameList.add(catDao.getCategoryById(i).getName());
        }
        String categoryString = ListOps.createStringFromList(categoryNameList);
        blogPost.setCategoryString(categoryString);
        List<String> tagNameList = new ArrayList<>();
        List<Integer> tagIdList = dao.getAllTagIdsByBlogPostId(blogPost.getBlogPostId());
        blogPost.setTagIds((ArrayList) tagIdList);
        for (Integer i : tagIdList) {
            tagNameList.add(tagDao.getTagById(i).getName());
        }
        String tagString = ListOps.createStringFromList(tagNameList);
        blogPost.setTagString(tagString);
        model.addAttribute("blogPost", blogPost);
        
        return "/displayEditBlogPost";
    }

    @RequestMapping(value = {"/confirmEditBlogPost","/displaySubmittedBlogPost/confirmEditBlogPost"}, method = RequestMethod.POST)
    public String confirmEditBlogPost(Model model, @ModelAttribute BlogPost blogPost, HttpServletRequest req,
                                        @RequestParam String tagString, @RequestParam String categoryString) {
        
        int blogPostId = Integer.parseInt(req.getParameter("blogPostId"));
        blogPost.setBlogPostId(blogPostId);
        ArrayList<Tag> tagList = (ArrayList<Tag>) tagDao.addTagsFromString(tagString);
        blogPost.setTagIds((ArrayList<Integer>) ListOps.createTagIdListFromTagList(tagList));
        ArrayList<Category> categoryList = (ArrayList<Category>) catDao.addCategoriesFromString(categoryString);
        blogPost.setCategoryIds((ArrayList<Integer>) ListOps.createCategoryIdListFromCategoryList(categoryList));
        dao.updateBlogPost(blogPost);
        model.addAttribute("blogPostList", dao.getAllBlogPosts_WithSummary());
        setCategoriesTagsDatesStaticPages(model);
        
        List<BlogPost> blogPostList = dao.getAllBlogPosts();
        model.addAttribute("numberOfPages", calculateNumberOfPages(blogPostList, 5));
        
        int currentPage = setCurrentPage(req, model);
        model.addAttribute("totalBlogPostCount", blogPostList.size());
        
        model.addAttribute("endpoint", "home");
        
        return "redirect:/pendingApproval";
    }
    
    @RequestMapping(value={"/approveBlogPost","/displaySubmittedBlogPost/approveBlogPost"}, method=RequestMethod.GET)
    public String approveBlogPostFromPage(Model model, HttpServletRequest req) {
        int blogPostId = Integer.parseInt(req.getParameter("blogPostId"));
        dao.approveBlogPost(blogPostId);
        return "redirect:/pendingApproval";
    }
    
    @RequestMapping(value={"/unapproveBlogPost","/displaySubmittedBlogPost/unapproveBlogPost"}, method=RequestMethod.GET)
    public String unapproveBlogPost(Model model, HttpServletRequest req) {
        int blogPostId = Integer.parseInt(req.getParameter("blogPostId"));
        dao.unapproveBlogPost(blogPostId);
        return "redirect:/pendingApproval";
    }
    
    private void setCategoriesTagsDatesStaticPages(Model model) {
        model.addAttribute("CategoryList", catDao.getAllActiveCategories());
        model.addAttribute("tagList", tagDao.getAllTags());        
        model.addAttribute("yearMonthsMap", dao.getAllUniqueYearMonths());
        model.addAttribute("staticPageLinks", spDao.getAllStaticPageLinks());        
    }
    
    private int calculateNumberOfPages(List<BlogPost> blogPosts, int numOfPostsPerPage) {
        // need number of pages to dynamically change pageNumbers at bottom of jsp page
        int blogPostSize = blogPosts.size();
        // 1 page is default
        int numOfPages = 1;
        // to see how many pages we need:
        if (blogPostSize % numOfPostsPerPage == 0) {
            numOfPages = blogPostSize / numOfPostsPerPage;
        } else {
            numOfPages = (blogPostSize / numOfPostsPerPage) + 1;
        }
        
        return numOfPages;
    }
    
    private int setCurrentPage(HttpServletRequest req, Model model) {
        // default current page is 1
        int currentPage = 1;
        if (req.getParameter("page") != null) {
            currentPage = Integer.parseInt(req.getParameter("page"));
        }
        model.addAttribute("currentPage", currentPage);
        return currentPage;
    }

    private List<BlogPost> displayPostsPerPage(List<BlogPost> blogPosts, int pageNumber, int numOfPostsPerPage) {
        int postsToShowBegin = (((pageNumber - 1) * numOfPostsPerPage));
        int postsToShowEnd = (pageNumber * numOfPostsPerPage);
        
        List<BlogPost> postsToDisplay;
        try {
            postsToDisplay = blogPosts.subList(postsToShowBegin, postsToShowEnd);
        } catch (IndexOutOfBoundsException inOutEx) {
            postsToDisplay = blogPosts.subList(postsToShowBegin, blogPosts.size());    
        }
        return postsToDisplay;
    }    
    
}
