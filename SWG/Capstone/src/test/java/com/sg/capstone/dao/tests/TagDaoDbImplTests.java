/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao.tests;

import com.sg.capstone.dao.BlogDao;
import com.sg.capstone.dao.TagDao;
import com.sg.capstone.model.BlogPost;
import com.sg.capstone.model.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class TagDaoDbImplTests {
  
    private TagDao dao;
    private BlogDao blogDao;
    
    Tag[] tagsForTesting = new Tag[3]; 
    
    BlogPost[] blogPostsForTesting = new BlogPost[3];    
    
    public TagDaoDbImplTests() {        
    }
    
    @Before
    public void setUp() {
        // Ask Spring for my DAO
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (TagDao) ctx.getBean("TagDao");
        blogDao = (BlogDao) ctx.getBean("BlogDao");
        // Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        
        cleaner.execute("truncate blogPost_tags");
        cleaner.execute("truncate blogPost");
        cleaner.execute("truncate tags");
               
        Tag tag1 = new Tag();
        tag1.setName("cake");
        
        Tag tag2 = new Tag();
        tag2.setName("space jam");
        
        Tag tag3 = new Tag();
        tag3.setName("cookies");
        
        tagsForTesting[0] = tag1;
        tagsForTesting[1] = tag2;
        tagsForTesting[2] = tag3;
        
        ArrayList<Integer> categoriesForInsertion = new ArrayList<>();
        
        BlogPost blogPost1 = new BlogPost();
        blogPost1.setTitle("Post1");
        blogPost1.setDate("2016-12-06 21:38:31");
        blogPost1.setCategoryIds(categoriesForInsertion);
        
        BlogPost blogPost2 = new BlogPost();
        blogPost2.setTitle("Post2");
        blogPost2.setDate("2016-12-07 09:34:38");
        blogPost2.setCategoryIds(categoriesForInsertion);        
        
        BlogPost blogPost3 = new BlogPost();
        blogPost3.setTitle("Post3");
        blogPost3.setDate("2016-12-01 13:36:50");
        blogPost3.setCategoryIds(categoriesForInsertion);
        
        blogPostsForTesting[0] = blogPost1;
        blogPostsForTesting[1] = blogPost2;
        blogPostsForTesting[2] = blogPost3;     
    }
    
    @Test
    public void testIntegrativeTesting() {
        // add, delete, get tag by id, get all tags
        assertTrue(dao.addTag(tagsForTesting[0]));
        assertTrue(dao.addTag(tagsForTesting[1]));
        assertTrue(dao.addTag(tagsForTesting[2]));
        
        // create blogPost objects
        BlogPost blogPost1 = blogPostsForTesting[0];
        BlogPost blogPost2 = blogPostsForTesting[1];
        BlogPost blogPost3 = blogPostsForTesting[2];
        
        // create arrayList of tagIds to insert into blogPosts
        ArrayList<Integer> blogTag1 = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> blogTag2 = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> blogTag3 = new ArrayList<>(Arrays.asList(3));
        
        // set arrayList to BlogPost objects
        blogPost1.setTagIds(blogTag1);
        blogPost2.setTagIds(blogTag2);
        blogPost3.setTagIds(blogTag3);
        
        blogDao.addBlogPost(blogPost1);
        blogDao.addBlogPost(blogPost2);
        blogDao.addBlogPost(blogPost3);
        
        BlogPost fromDbBlog1 = blogDao.getBlogPostById(1);
        BlogPost fromDbBlog2 = blogDao.getBlogPostById(2);

        ArrayList<Integer> emptyCategoriesArray = new ArrayList<>();
        fromDbBlog1.setCategoryIds(emptyCategoriesArray);
        fromDbBlog2.setCategoryIds(emptyCategoriesArray);
        fromDbBlog1.setTagIds(new ArrayList<>(blogDao.getAllTagIdsByBlogPostId(1)));
        fromDbBlog2.setTagIds(new ArrayList<>(blogDao.getAllTagIdsByBlogPostId(2)));
        
        fromDbBlog1.setIsApproved(1);
        fromDbBlog2.setIsApproved(1);
        
        blogDao.updateBlogPost(fromDbBlog1);
        blogDao.updateBlogPost(fromDbBlog2);
        
        assertEquals(2, dao.getAllTags().size());
        assertEquals("cake", dao.getTagById(1).getName());
        
        String testTagsString = "pie,kolachkie,buckeye";
        
        dao.addTagsFromString(testTagsString);
        
        // test delete
        
        dao.deleteTag(1);
        assertEquals(1, dao.getAllTags().size());
        assertNull(dao.getTagById(1));
        
    }
     
    @Test
    public void testAddCategoriesFromString() {
        String testTagsString = "pie,kolachkie,buckeye";
        List<Tag> testTagsList = dao.addTagsFromString(testTagsString);
        assertEquals(3, testTagsList.size());
        assertEquals("pie", testTagsList.get(0).getName());
        assertEquals("kolachkie", testTagsList.get(1).getName());
        assertEquals("buckeye", testTagsList.get(2).getName());
    }
    
    
}
