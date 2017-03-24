package com.sg.capstone.dao.tests;

import com.sg.capstone.dao.BlogDao;
import com.sg.capstone.dao.CategoryDao;
import com.sg.capstone.dao.TagDao;
import com.sg.capstone.model.BlogPost;
import com.sg.capstone.model.Category;
import com.sg.capstone.model.Tag;
import com.sg.capstone.model.ops.ListOps;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class BlogDaoDbImplTests {
    
    private BlogDao blogDao;
    private TagDao tagDao;
    private CategoryDao catDao;
    
    BlogPost[] blogPostsForTesting = new BlogPost[3];
    
    public BlogDaoDbImplTests() {        
    }
    
    @Before
    public void setUp() {
        // Ask Spring for my DAO
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        blogDao = (BlogDao) ctx.getBean("BlogDao");
        tagDao = (TagDao) ctx.getBean("TagDao");
        catDao = (CategoryDao) ctx.getBean("CategoryDao");
        // Grab a JdbcTemplate to use for cleaning up
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("truncate blogPost");
        cleaner.execute("truncate categories");
        cleaner.execute("truncate tags");
        cleaner.execute("truncate blogPost_categories");
        cleaner.execute("truncate blogPost_tags");
        
        BlogPost blogPost1 = new BlogPost();
        blogPost1.setDate("2015-10-01 00:00:00");
        blogPost1.setTitle("Blog Post 1");
        blogPost1.setImagePath("https://upload.wikimedia.org/wikipedia/en/1/14/Space_jam.jpg");
        blogPost1.setBlogText("Blog Text 1");
        
        BlogPost blogPost2 = new BlogPost();
        blogPost2.setDate("2015-10-02 10:00:00");
        blogPost2.setTitle("Blog Post 2");
        blogPost2.setImagePath("https://upload.wikimedia.org/wikipedia/en/1/14/Space_jam.jpg");
        blogPost2.setBlogText("Blog Text 2");
        
        BlogPost blogPost3 = new BlogPost();
        blogPost3.setDate("2016-12-03 20:00:00");
        blogPost3.setTitle("Blog Post 3");
        blogPost3.setImagePath("https://upload.wikimedia.org/wikipedia/en/1/14/Space_jam.jpg");
        blogPost3.setBlogText("Blog Text 3");
        
        Tag tag1 = new Tag();
        tag1.setName("tag1");
        tagDao.addTag(tag1);
        
        Tag tag2 = new Tag();
        tag2.setName("tag2");
        tagDao.addTag(tag2);
        
        Tag tag3 = new Tag();
        tag3.setName("tag3");
        tagDao.addTag(tag3);
        
        Category cat1 = new Category();
        cat1.setName("cat1");
        catDao.addCategory(cat1);
        
        Category cat2 = new Category();
        cat2.setName("cat2");
        catDao.addCategory(cat2);
        
        Category cat3 = new Category();
        cat3.setName("cat3");
        catDao.addCategory(cat3);
        
        ArrayList<Integer> blogPost1TagIds = new ArrayList<>();
        blogPost1TagIds.add(1);
        blogPost1.setTagIds(blogPost1TagIds);
        
        ArrayList<Integer> blogPost2TagIds = new ArrayList<>();
        blogPost2TagIds.add(1);
        blogPost2TagIds.add(2);
        blogPost2.setTagIds(blogPost2TagIds);
        
        ArrayList<Integer> blogPost3TagIds = new ArrayList<>();
        blogPost3TagIds.add(1);
        blogPost3TagIds.add(2);
        blogPost3TagIds.add(3);
        blogPost3.setTagIds(blogPost3TagIds);
        
        ArrayList<Integer> blogPost1CategoryIds = new ArrayList<>();
        blogPost1CategoryIds.add(1);
        blogPost1.setCategoryIds(blogPost1CategoryIds);
        
        ArrayList<Integer> blogPost2CategoryIds = new ArrayList<>();
        blogPost2CategoryIds.add(1);
        blogPost2CategoryIds.add(2);
        blogPost2.setCategoryIds(blogPost2CategoryIds);
        
        ArrayList<Integer> blogPost3CategoryIds = new ArrayList<>();
        blogPost3CategoryIds.add(1);
        blogPost3CategoryIds.add(2);
        blogPost3CategoryIds.add(3);
        blogPost3.setCategoryIds(blogPost3CategoryIds);
        
        blogPostsForTesting[0] = blogPost1;
        blogPostsForTesting[1] = blogPost2;
        blogPostsForTesting[2] = blogPost3;
    }
    
    @Test
    public void testAddBlogPost() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        BlogPost fromDb1 = blogDao.getBlogPostById(1);
        BlogPost fromDb2 = blogDao.getBlogPostById(2);
        BlogPost fromDb3 = blogDao.getBlogPostById(3);
        
        assertEquals(blogPostsForTesting[0].getTitle(), fromDb1.getTitle());
        assertEquals(blogPostsForTesting[1].getTitle(), fromDb2.getTitle());
        assertEquals(blogPostsForTesting[2].getTitle(), fromDb3.getTitle());
        
        assertEquals(3, blogDao.getAllBlogPosts().size());
    }
    
    
    @Test
    public void testUpdateBlogPost() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        BlogPost updatedBlogPost1 = new BlogPost();
        updatedBlogPost1.setBlogPostId(1);
        updatedBlogPost1.setDate("2016-12-01 01:01:01");
        updatedBlogPost1.setTitle("Updated Title 1");
        updatedBlogPost1.setImagePath("https://upload.wikimedia.org/wikipedia/en/1/14/Space_jam.jpg");
        updatedBlogPost1.setBlogText("Updated Blog Text 1");
        updatedBlogPost1.setTagIds(new ArrayList<>());
        updatedBlogPost1.setCategoryIds(new ArrayList<>());
        
        BlogPost updatedBlogPost2 = new BlogPost();
        updatedBlogPost2.setBlogPostId(2);
        updatedBlogPost2.setDate("2016-12-02 02:02:02");
        updatedBlogPost2.setTitle("Updated Title 2");
        updatedBlogPost2.setImagePath("https://upload.wikimedia.org/wikipedia/en/1/14/Space_jam.jpg");
        updatedBlogPost2.setBlogText("Updated Blog Text 2");
        updatedBlogPost2.setTagIds(new ArrayList<>());
        updatedBlogPost2.setCategoryIds(new ArrayList<>());
        
        BlogPost updatedBlogPost3 = new BlogPost();
        updatedBlogPost3.setBlogPostId(3);
        updatedBlogPost3.setDate("2016-12-03 03:03:03");
        updatedBlogPost3.setTitle("Updated Title 3");
        updatedBlogPost3.setImagePath("https://upload.wikimedia.org/wikipedia/en/1/14/Space_jam.jpg");
        updatedBlogPost3.setBlogText("Updated Blog Text 3");
        updatedBlogPost3.setTagIds(new ArrayList<>());
        updatedBlogPost3.setCategoryIds(new ArrayList<>());
        
        blogDao.updateBlogPost(updatedBlogPost1);
        blogDao.updateBlogPost(updatedBlogPost2);
        blogDao.updateBlogPost(updatedBlogPost3);
        
        assertEquals(updatedBlogPost1.getTitle(), blogDao.getBlogPostById(1).getTitle());
        assertEquals(updatedBlogPost2.getTitle(), blogDao.getBlogPostById(2).getTitle());
        assertEquals(updatedBlogPost3.getTitle(), blogDao.getBlogPostById(3).getTitle());
        
        assertEquals(updatedBlogPost1.getBlogText(), blogDao.getBlogPostById(1).getBlogText());
        assertEquals(updatedBlogPost2.getBlogText(), blogDao.getBlogPostById(2).getBlogText());
        assertEquals(updatedBlogPost3.getBlogText(), blogDao.getBlogPostById(3).getBlogText());
    }
    
    @Test
    public void testDeleteBlogPost() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        blogDao.deleteBlogPost(1);
        blogDao.deleteBlogPost(2);
        blogDao.deleteBlogPost(3);
        
        assertNull(blogDao.getBlogPostById(1));
        assertNull(blogDao.getBlogPostById(2));
        assertNull(blogDao.getBlogPostById(3));
    }
    
    @Test
    public void testGetAllBlogPosts() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        List<BlogPost> allBlogPosts = blogDao.getAllBlogPosts();
        
        // Descending order...
        assertEquals(blogPostsForTesting[0].getBlogPostId(), allBlogPosts.get(2).getBlogPostId());
        assertEquals(blogPostsForTesting[1].getBlogPostId(), allBlogPosts.get(1).getBlogPostId());
        assertEquals(blogPostsForTesting[2].getBlogPostId(), allBlogPosts.get(0).getBlogPostId());
        
        assertEquals(3, blogDao.getAllBlogPosts().size());
    }
    
    @Test
    public void testGetAllApprovedBlogPosts() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        blogDao.unapproveBlogPost(1);
        blogDao.approveBlogPost(2);
        blogDao.approveBlogPost(3);
        
        List<BlogPost> allApprovedBlogPosts = blogDao.getAllApprovedBlogPosts();
        
        assertEquals(2, allApprovedBlogPosts.size());
    }
    
    
    @Test
    public void testGetAllBlogPostsByDate() {
        blogDao.addBlogPost(blogPostsForTesting[0]); // October 2015
        blogDao.addBlogPost(blogPostsForTesting[1]); // October 2015
        blogDao.addBlogPost(blogPostsForTesting[2]); // December 2016
        
        blogDao.approveBlogPost(1);
        blogDao.approveBlogPost(2);
        blogDao.approveBlogPost(3);
        
        List<BlogPost> october2015Posts  = blogDao.getAllBlogPostsByDate(10, 2015);
        
        assertEquals(2, october2015Posts.size());
        // Descending order...
        assertEquals(blogPostsForTesting[0].getBlogPostId(), october2015Posts.get(1).getBlogPostId());
        assertEquals(blogPostsForTesting[1].getBlogPostId(), october2015Posts.get(0).getBlogPostId());
    }

    @Test
    public void testGetAllBlogPosts_WithSummary() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        blogDao.approveBlogPost(1);
        blogDao.approveBlogPost(2);
        blogDao.approveBlogPost(3);
        
        List<BlogPost> allBlogPosts = blogDao.getAllBlogPosts_WithSummary();
        
        assertEquals(blogPostsForTesting[0].getBlogPostId(), allBlogPosts.get(0).getBlogPostId());
        assertEquals(blogPostsForTesting[1].getBlogPostId(), allBlogPosts.get(1).getBlogPostId());
        assertEquals(blogPostsForTesting[2].getBlogPostId(), allBlogPosts.get(2).getBlogPostId());
        
        assertEquals(3, blogDao.getAllBlogPosts_WithSummary().size());
    }
    
    @Test
    public void testGetAllBlogPostsByCategoryId() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        blogDao.approveBlogPost(1);
        blogDao.approveBlogPost(2);
        blogDao.approveBlogPost(3);
        
        // Should be all 3 blog posts
        List<BlogPost> blogPostsWithCategory1 = blogDao.getAllBlogPostsByCategoryId(1);
        
        // Should only be blog posts 2 and 3
        List<BlogPost> blogPostsWithCategory2 = blogDao.getAllBlogPostsByCategoryId(2);
        
        // Should only be blog post 3
        List<BlogPost> blogPostsWithCategory3 = blogDao.getAllBlogPostsByCategoryId(3);
        
        assertEquals(3, blogPostsWithCategory1.size());
        assertEquals(2, blogPostsWithCategory2.size());
        assertEquals(1, blogPostsWithCategory3.size());
    }
    
    @Test
    public void testGetAllBlogPostsByTagId() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        blogDao.approveBlogPost(1);
        blogDao.approveBlogPost(2);
        blogDao.approveBlogPost(3);
        
        // Should be all 3 blog posts
        List<BlogPost> blogPostsWithTag1 = blogDao.getAllBlogPostsByTagId(1);
        
        // Should only be blog posts 2 and 3
        List<BlogPost> blogPostsWithTag2 = blogDao.getAllBlogPostsByTagId(2);
        
        // Should only be blog post 3
        List<BlogPost> blogPostsWithTag3 = blogDao.getAllBlogPostsByTagId(3);
        
        assertEquals(3, blogPostsWithTag1.size());
        assertEquals(2, blogPostsWithTag2.size());
        assertEquals(1, blogPostsWithTag3.size());
    }
    
    @Test
    public void testGetAllCategoryIdsByBlogPostId() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        blogDao.approveBlogPost(1);
        blogDao.approveBlogPost(2);
        blogDao.approveBlogPost(3);
        
        List<Integer> categoriesOfBlogPost1 = blogDao.getAllCategoryIdsByBlogPostId(1);
        List<Integer> categoriesOfBlogPost2 = blogDao.getAllCategoryIdsByBlogPostId(2);
        List<Integer> categoriesOfBlogPost3 = blogDao.getAllCategoryIdsByBlogPostId(3);
        
        // Blog Post 1 has 1 category
        // Blog Post 2 has 2 categories
        // Blog Post 3 has 3 categories
        assertEquals(1, categoriesOfBlogPost1.size());
        assertEquals(2, categoriesOfBlogPost2.size());
        assertEquals(3, categoriesOfBlogPost3.size());
    }
    
    @Test
    public void testGetAllTagIdsByBlogPostId() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        blogDao.approveBlogPost(1);
        blogDao.approveBlogPost(2);
        blogDao.approveBlogPost(3);
        
        List<Integer> tagsOfBlogPost1 = blogDao.getAllTagIdsByBlogPostId(1);
        List<Integer> tagsOfBlogPost2 = blogDao.getAllTagIdsByBlogPostId(2);
        List<Integer> tagsOfBlogPost3 = blogDao.getAllTagIdsByBlogPostId(3);
        
        // Blog Post 1 has 1 tag
        // Blog Post 2 has 2 tags
        // Blog Post 3 has 3 tags
        assertEquals(1, tagsOfBlogPost1.size());
        assertEquals(2, tagsOfBlogPost2.size());
        assertEquals(3, tagsOfBlogPost3.size());
    }
    
    @Test
    public void testSearchBlogPostsByKeyword() {
        blogDao.addBlogPost(blogPostsForTesting[0]);
        blogDao.addBlogPost(blogPostsForTesting[1]);
        blogDao.addBlogPost(blogPostsForTesting[2]);
        
        blogDao.approveBlogPost(1);
        blogDao.approveBlogPost(2);
        blogDao.approveBlogPost(3);
        
        List<BlogPost> search1 = blogDao.searchBlogPostsByKeyword("Post 1");
        List<BlogPost> search2 = blogDao.searchBlogPostsByKeyword("Post 2");
        List<BlogPost> search3 = blogDao.searchBlogPostsByKeyword("Post 3");
        
        assertEquals("Blog Text 1", search1.get(0).getBlogText());
        assertEquals("Blog Text 2", search2.get(0).getBlogText());
        assertEquals("Blog Text 3", search3.get(0).getBlogText());
    }
}
