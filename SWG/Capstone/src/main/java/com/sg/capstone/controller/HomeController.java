package com.sg.capstone.controller;

import com.sg.capstone.dao.BlogDao;
import com.sg.capstone.dao.CategoryDao;
import com.sg.capstone.dao.StaticPageDao;
import com.sg.capstone.dao.TagDao;
import com.sg.capstone.model.BlogPost;
import com.sg.capstone.model.ops.MonthConverter;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    private BlogDao dao;
    private CategoryDao catDao;
    private StaticPageDao spDao;
    private TagDao tagDao;
    
    @Inject
    public HomeController(BlogDao dao,CategoryDao catDao, StaticPageDao spDao, TagDao tagDao) {
        this.dao = dao;
        this.catDao=catDao;
        this.spDao = spDao;
        this.tagDao = tagDao;  
    }
  

    @RequestMapping(value = {"/", "/home", "/home/page"}, method = RequestMethod.GET)
    public String displayHomePage(Model model, HttpServletRequest req) {
        // method to set categories, tags, & date information in side filter bar, and static pages in nav bar
        setCategoriesTagsDatesStaticPages(model);
        
        // -- PAGINATION --
        // right now make number of posts per page only 5, later maybe add option to change amt of posts displayed on page
        List<BlogPost> blogPostList = dao.getAllBlogPosts_WithSummary();
        model.addAttribute("numberOfPages", calculateNumberOfPages(blogPostList, 5));
        
        int currentPage = setCurrentPage(req, model);
        model.addAttribute("totalBlogPostCount", blogPostList.size());
        model.addAttribute("blogPostList", displayPostsPerPage(blogPostList, currentPage, 5));
        
        model.addAttribute("endpoint", "home");

        return "home";
    }
    
    @RequestMapping(value={"/searchPosts","/displaySubmittedBlogPost/searchPosts","/staticPage/searchPosts"}, method={RequestMethod.GET, RequestMethod.POST})
    public String displayHomePage_WithSearchCriteria(HttpServletRequest req, Model model) {
        // method to set categories, tags, & date information in side filter bar, and static pages in nav bar
        setCategoriesTagsDatesStaticPages(model);
        
        String searchCriteria;
        if (req.getParameter("searchBlogPosts") != null) {
            searchCriteria = req.getParameter("searchBlogPosts");
        } else {
            searchCriteria = req.getParameter("searchCriteria");
        }
        
        int currentPage = setCurrentPage(req, model);
        
        List<BlogPost> blogPostList = dao.searchBlogPostsByKeyword(searchCriteria);
        // named it the same as above so we don't have to specify new jstl tags on the jsp page
        model.addAttribute("searchCriteria", searchCriteria);
        model.addAttribute("totalBlogPostCount", blogPostList.size());        
        model.addAttribute("blogPostList", displayPostsPerPage(blogPostList, currentPage, 5));        
        model.addAttribute("numberOfPages", calculateNumberOfPages(blogPostList, 5));
        model.addAttribute("endpoint", "searchPosts");
        return "home";
    }   
    
    @RequestMapping(value={"/searchCategories","/displaySubmittedBlogPost/searchCategories","/staticPage/searchCategories"}, method=RequestMethod.GET)
    public String displayHomePage_WithCategory(HttpServletRequest req, Model model){     

        int CategoryId;
        if (req.getParameter("categoryId") != null) {
            CategoryId = Integer.parseInt(req.getParameter("categoryId"));
        } else {
            CategoryId = Integer.parseInt(req.getParameter("categoryIdPage"));
        }
        
        List<BlogPost> blogPostList = dao.getAllBlogPostsByCategoryId(CategoryId);
        String categoryNameResult = catDao.getCategoryById(CategoryId).getName();
        int currentPage = setCurrentPage(req, model);
        
        // method to set categories, tags, & date information in side filter bar, and static pages in nav bar
        setCategoriesTagsDatesStaticPages(model); 
        model.addAttribute("categoryIdResult", CategoryId);
        model.addAttribute("categoryNameResult", categoryNameResult);        
        model.addAttribute("totalBlogPostCount", blogPostList.size());        
        model.addAttribute("blogPostList", displayPostsPerPage(blogPostList, currentPage, 5));
        model.addAttribute("numberOfPages", calculateNumberOfPages(blogPostList, 5));        
        model.addAttribute("endpoint", "searchCategories");      
        return "home";
    }
    
    @RequestMapping(value={"/searchTags","/displaySubmittedBlogPost/searchTags","/staticPage/searchTags"}, method=RequestMethod.GET)
    public String displayHomePage_WithTags(HttpServletRequest req, Model model){
 
        int TagId;
        if (req.getParameter("tagId") != null) {
            TagId = Integer.parseInt(req.getParameter("tagId"));
        } else {
            TagId = Integer.parseInt(req.getParameter("tagIdPage"));
        }        
        
        List<BlogPost> blogPostList = dao.getAllBlogPostsByTagId(TagId);
        String tagNameResult = tagDao.getTagById(TagId).getName();
        int currentPage = setCurrentPage(req, model);        
        
        // method to set categories, tags, & date information in side filter bar, and static pages in nav bar
        setCategoriesTagsDatesStaticPages(model);
        model.addAttribute("tagIdResult", TagId);
        model.addAttribute("tagNameResult", tagNameResult);
        model.addAttribute("totalBlogPostCount", blogPostList.size());        
        model.addAttribute("blogPostList", displayPostsPerPage(blogPostList, currentPage, 5));
        model.addAttribute("numberOfPages", calculateNumberOfPages(blogPostList, 5));        
        model.addAttribute("endpoint", "searchTags");
        return "home";
    }
    
    @RequestMapping(value={"/searchDate", "/displaySubmittedBlogPost/searchDate", "/staticPage/searchDate"}, method=RequestMethod.GET)
    public String displayHomePage_DateFilter(HttpServletRequest req, Model model){
        // method to set categories, tags, & date information in side filter bar, and static pages in nav bar
        setCategoriesTagsDatesStaticPages(model);

        // get year & month filter criteria        
        List<BlogPost> blogPostList = calculateDateCriteria(req, model);
        int currentPage = setCurrentPage(req, model);   
        
        model.addAttribute("totalBlogPostCount", blogPostList.size());        
        model.addAttribute("blogPostList", displayPostsPerPage(blogPostList, currentPage, 5));    
        model.addAttribute("numberOfPages", calculateNumberOfPages(blogPostList, 5));        
        model.addAttribute("endpoint", "searchDate");        
        return "home";
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
    
    private void setCategoriesTagsDatesStaticPages(Model model) {
        model.addAttribute("CategoryList", catDao.getAllActiveCategories());
        model.addAttribute("tagList", tagDao.getAllTags());        
        model.addAttribute("yearMonthsMap", dao.getAllUniqueYearMonths());
        model.addAttribute("staticPageLinks", spDao.getAllStaticPageLinks());
    }
    
    private List<BlogPost> calculateDateCriteria(HttpServletRequest req, Model model) {
        // get year & month filter criteria
        
        String yearMonthFilter;
        if (req.getParameter("yearMonthFilter") != null) {
            yearMonthFilter = req.getParameter("yearMonthFilter");
        } else {
            yearMonthFilter = req.getParameter("yearMonthFilterPage");
        }         

        // split the year::month string on the delimiter "::"
        String[] filterSplitArray = yearMonthFilter.split("::");
        // define year for SQL query
        int filterYearCriteria = Integer.parseInt(filterSplitArray[0]); 
        MonthConverter monthConverter = new MonthConverter();
        // define month (in integer form) for SQL query
        int filterMonthIntCriteria = monthConverter.getMonthInt(filterSplitArray[1].toUpperCase());      
        
        // create string to display at top for informational purposes
        String monthYearCriteria = filterSplitArray[1] + " " + filterSplitArray[0];
        model.addAttribute("monthYearCriteria", monthYearCriteria);   
        
        model.addAttribute("yearMonthFilterResult", yearMonthFilter);
        
        return dao.getAllBlogPostsByDate(filterMonthIntCriteria, filterYearCriteria);
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
}
