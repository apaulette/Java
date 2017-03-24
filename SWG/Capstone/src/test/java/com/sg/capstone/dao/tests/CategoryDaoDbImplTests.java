/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao.tests;

import com.sg.capstone.dao.BlogDao;
import com.sg.capstone.dao.CategoryDao;
import com.sg.capstone.model.BlogPost;
import com.sg.capstone.model.Category;
import com.sg.capstone.model.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class CategoryDaoDbImplTests {
    
    private CategoryDao dao;
    private BlogDao blogDao;
    
    Category[] categoriesForTesting = new Category[3];
    
    BlogPost[] blogPostsForTesting = new BlogPost[3];
    
    public CategoryDaoDbImplTests() {        
    }
    
    @Before
    public void setUp() {
        // Ask Spring for my DAO
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (CategoryDao) ctx.getBean("CategoryDao");
        blogDao = (BlogDao) ctx.getBean("BlogDao");
        // Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        
        cleaner.execute("truncate blogPost_categories");
        cleaner.execute("truncate blogPost");
        cleaner.execute("truncate categories");
               
        Category category1 = new Category();
        category1.setName("Chocolate");
        
        Category category2 = new Category();
        category2.setName("Space Jam");
        
        Category category3 = new Category();
        category3.setName("Holidays");
        
        categoriesForTesting[0] = category1;
        categoriesForTesting[1] = category2;
        categoriesForTesting[2] = category3;
                
        ArrayList<Integer> tagsForInsertion = new ArrayList<>();
        
        BlogPost blogPost1 = new BlogPost();
        blogPost1.setTitle("Post1");
        blogPost1.setDate("2016-12-06 21:38:31");
        blogPost1.setTagIds(tagsForInsertion);
        
        BlogPost blogPost2 = new BlogPost();
        blogPost2.setTitle("Post2");
        blogPost2.setDate("2016-12-07 09:34:38");
        blogPost2.setTagIds(tagsForInsertion);        
        blogPost2.setIsApproved(1);
        
        BlogPost blogPost3 = new BlogPost();
        blogPost3.setTitle("Post3");
        blogPost3.setDate("2016-12-01 13:36:50");
        blogPost3.setTagIds(tagsForInsertion);
        blogPost3.setIsApproved(0);

        blogPostsForTesting[0] = blogPost1;
        blogPostsForTesting[1] = blogPost2;
        blogPostsForTesting[2] = blogPost3;        
    }
        
    @Test
    public void testAddCategory() {
        // arrange
        dao.addCategory(categoriesForTesting[0]);
        dao.addCategory(categoriesForTesting[1]);
        dao.addCategory(categoriesForTesting[2]);
        // act
        Category fromDb1 = dao.getCategoryById(1);
        Category fromDb2 = dao.getCategoryById(2);
        Category fromDb3 = dao.getCategoryById(3);
        // assert
        assertEquals(fromDb1.getName(), categoriesForTesting[0].getName());
        assertEquals(fromDb2.getName(), categoriesForTesting[1].getName());
        assertEquals(fromDb3.getName(), categoriesForTesting[2].getName());       
        assertEquals(3, dao.getAllCategories().size());     
    }

    @Test
    public void testDeleteCategory() {
        
        dao.addCategory(categoriesForTesting[0]);

        Category fromDb1 = dao.getCategoryById(1);
        assertEquals(fromDb1.getName(), categoriesForTesting[0].getName());
        assertEquals(1, dao.getAllCategories().size());
        
        dao.deleteCategory(fromDb1.getCategoryId());       
        assertEquals(0, dao.getAllCategories().size());
        
        dao.addCategory(categoriesForTesting[1]);
        dao.addCategory(categoriesForTesting[2]);
        
        Category fromDb2 = dao.getCategoryById(2);
        Category fromDb3 = dao.getCategoryById(3);
        
        assertEquals(2, dao.getAllCategories().size());
        dao.deleteCategory(fromDb2.getCategoryId());
        assertEquals(1, dao.getAllCategories().size());
        dao.deleteCategory(fromDb3.getCategoryId());
        
        List<Category> expectedEmptyList = Arrays.asList();
        
        assertThat(dao.getAllCategories(), is(expectedEmptyList));
        
        assertNull(dao.getCategoryById(fromDb2.getCategoryId()));
        assertNull(dao.getCategoryById(fromDb3.getCategoryId()));        
    }
    
    @Test
    public void testAllActiveCategories() {
         
        dao.addCategory(categoriesForTesting[0]);
        dao.addCategory(categoriesForTesting[1]);
        dao.addCategory(categoriesForTesting[2]); 
        
        // get categories from Db
        Category fromDbCat1 = dao.getCategoryById(1);
        Category fromDbCat2 = dao.getCategoryById(2);
        Category fromDbCat3 = dao.getCategoryById(3);
        
        // create blogPost objects
        BlogPost blogPost1 = blogPostsForTesting[0];
        BlogPost blogPost2 = blogPostsForTesting[1];
        BlogPost blogPost3 = blogPostsForTesting[2];
        
        // create arrayList of categoryIds to insert into blogPosts
        ArrayList<Integer> blogCat1 = new ArrayList<>(Arrays.asList(fromDbCat1.getCategoryId()));
        ArrayList<Integer> blogCat2 = new ArrayList<>(Arrays.asList(fromDbCat2.getCategoryId()));
        ArrayList<Integer> blogCat3 = new ArrayList<>(Arrays.asList(fromDbCat3.getCategoryId()));
        
        // set arrayList to BlogPost objects
        blogPost1.setCategoryIds(blogCat1);
        blogPost2.setCategoryIds(blogCat2);
        blogPost3.setCategoryIds(blogCat3);
        
        // by default blogPosts are not approved when they are added to Db
        assertEquals(0, dao.getAllActiveCategories().size());
        
        // add blogPosts to Db
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        BlogPost fromDbBlog1 = blogDao.getBlogPostById(1);
        BlogPost fromDbBlog2 = blogDao.getBlogPostById(2);
        BlogPost fromDbBlog3 = blogDao.getBlogPostById(3);
        ArrayList<Integer> emptyTagsArray = new ArrayList<>();
        fromDbBlog1.setTagIds(emptyTagsArray);
        fromDbBlog2.setTagIds(emptyTagsArray);
        fromDbBlog1.setCategoryIds(new ArrayList<>(blogDao.getAllCategoryIdsByBlogPostId(1)));
        fromDbBlog2.setCategoryIds(new ArrayList<>(blogDao.getAllCategoryIdsByBlogPostId(2)));
        
        
        
        fromDbBlog1.setIsApproved(1);
        fromDbBlog2.setIsApproved(1);
        
        blogDao.updateBlogPost(fromDbBlog1);
        blogDao.updateBlogPost(fromDbBlog2);
        
        // now can test getAllActiveCategories:
        assertEquals(2, dao.getAllActiveCategories().size());
}    

    @Test
    public void testAddCategoriesFromString() {
        String testCategoriesString = "Seasonal,chocolate,Cleveland";
        List<Category> testCategoriesList = dao.addCategoriesFromString(testCategoriesString);
        assertEquals(3, testCategoriesList.size());
        assertEquals("Seasonal", testCategoriesList.get(0).getName());
        assertEquals("chocolate", testCategoriesList.get(1).getName());
        assertEquals("Cleveland", testCategoriesList.get(2).getName());
    }
}
