/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.BlogPost;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class BlogDaoDbImpl implements BlogDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_BLOGPOST = "insert into blogPost (date, title, imagePath, blogText, isApproved) values (?, ?, ?, ?, 0)";
    private static final String SQL_DELETE_BLOGPOST = "delete from blogPost where blogPostId = ?";
    private static final String SQL_UPDATE_BLOGPOST = "update blogPost set date = ?, title = ?, imagePath = ?, blogText = ?, isApproved = ? where blogPostId= ?";
    private static final String SQL_SELECT_BLOGPOST = "select * from blogPost where blogPostId=?";
    private static final String SQL_SELECT_ALL_APPROVED_BLOGPOSTS = "select * from blogPost where isApproved= 1 order by `date` desc";
    private static final String SQL_APPROVE_BLOGPOST = "UPDATE blogPost SET isApproved=1 WHERE blogPostId = ?;";
    private static final String SQL_UNAPPROVE_BLOGPOST = "UPDATE blogPost SET isApproved=0 WHERE blogPostId = ?;";
    private static final String SQL_SELECT_ALL_BLOGPOST = "select * from blogPost order by `date` desc";
    private static final String SQL_SELECT_ALL_BLOGPOST_SUMMARY = "select `date`, `title`, `blogPostId`, `imagePath`, `isApproved`, substring(`blogText` , 1, 400) as `blogText` FROM `blogPost` WHERE isApproved = 1 order by `date` desc";
    private static final String SQL_SELECT_ALL_BLOGPOST_LIMITED_INFO = "select bp.blogPostId, bp.date, bp.title, bp.isApproved from blogPost bp";
    private static final String SQL_SELECT_ALL_BLOGPOST_BY_DATE = "select `date`, `title`, `blogPostId`, `imagePath`, `isApproved`, substring(`blogText` , 1, 400) as `blogText` FROM blogPost WHERE MONTH(`date`) = ? AND YEAR(`date`) = ? AND isApproved = 1 order by `date` desc";
    private static final String SQL_SELECT_ALL_BLOGPOST_BY_CATEGORY = "select bp.blogPostId, bp.date, bp.title, bp.imagePath, substring(`blogText` , 1, 400) as `blogText`, bp.isApproved from blogPost bp "
            + "join blogPost_categories cg on bp.blogPostId = cg.blogPostId where cg.categoryId = ? AND isApproved = 1 order by `date` desc";
    private static final String SQL_SELECT_ALL_BLOGPOST_BY_TAG = "select bp.blogPostId, bp.date, bp.title, bp.imagePath, substring(`blogText` , 1, 400) as `blogText`, bp.isApproved from blogPost bp "
            + "join blogPost_tags bpt on bp.blogPostId = bpt.blogPostId where bpt.tagId=? AND isApproved = 1 order by `date` desc";
    private static final String SQL_SEARCH_BLOGPOST_BY_KEYWORD = "select `date`, `title`, `blogPostId`, `imagePath`, `isApproved`, substring(`blogText` , 1, 400) as `blogText` from blogPost where (title like ? or blogText like ?) AND isApproved = 1 order by `date` desc";
    private static final String SQL_SELECT_ALL_UNIQUE_YEARS = "select year(date) as `year` from blogPost WHERE isApproved = 1 group by year(date) order by `year` desc";
    private static final String SQL_SELECT_ALL_UNIQUE_YEAR_MONTHS = "SELECT DISTINCT CONCAT (YEAR(`date`), ':', MONTHNAME(`date`)) AS `MonthYear` "
            + "FROM blogPost WHERE isApproved = 1 ORDER BY `date` asc";
    
    private static final String SQL_INSERT_BLOGPOST_TAGS = "insert into blogPost_tags (blogPostId, tagId) values(?, ?)";
    private static final String SQL_DELETE_BLOGPOST_TAGS = "delete from blogPost_tags where blogPostId = ?";
    private static final String SQL_SELECT_BLOGPOST_TAG_IDS_BY_BLOGPOST_ID = "select tagId from blogPost_tags where blogPostId = ?";
    
    private static final String SQL_INSERT_BLOGPOST_CATEGORIES = "insert into blogPost_categories (blogPostId, categoryId) values(?, ?)";
    private static final String SQL_DELETE_BLOGPOST_CATEGORIES = "delete from blogPost_categories where blogPostId = ?";
    private static final String SQL_SELECT_BLOGPOST_CATEGORY_IDS_BY_BLOGPOST_ID = "select categoryId from blogPost_categories where blogPostId = ?";
    
    
    @Override
    public void addBlogPost(BlogPost post) {
        jdbcTemplate.update(SQL_INSERT_BLOGPOST,
                post.getDate(),
                post.getTitle(),
                post.getImagePath(),
                post.getBlogText());
        post.setBlogPostId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        insertBlogPostTags(post);
        insertBlogPostCategories(post);
    }
    
    private void insertBlogPostTags(BlogPost blogPost) {
        final int blogPostId = blogPost.getBlogPostId();
        final ArrayList<Integer> tagIds = blogPost.getTagIds();

        jdbcTemplate.batchUpdate(SQL_INSERT_BLOGPOST_TAGS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, blogPostId);
                ps.setInt(2, tagIds.get(i));
            }

            @Override
            public int getBatchSize() {
                return tagIds.size();
            }
        });
    }
    
    private void insertBlogPostCategories(BlogPost blogPost) {
        final int blogPostId = blogPost.getBlogPostId();
        final ArrayList<Integer> categoryIds = blogPost.getCategoryIds();

        jdbcTemplate.batchUpdate(SQL_INSERT_BLOGPOST_CATEGORIES, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, blogPostId);
                ps.setInt(2, categoryIds.get(i));
            }

            @Override
            public int getBatchSize() {
                return categoryIds.size();
            }
        });
    }
    
    private void deleteBlogPostTags(BlogPost blogPost) {
        jdbcTemplate.update(SQL_DELETE_BLOGPOST_TAGS, blogPost.getBlogPostId());
    }
    
    private void deleteBlogPostCategories(BlogPost blogPost) {
        jdbcTemplate.update(SQL_DELETE_BLOGPOST_CATEGORIES, blogPost.getBlogPostId());
    }

    @Override
    public BlogPost getBlogPostById(int blogPostId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BLOGPOST, new blogPostMapper(), blogPostId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateBlogPost(BlogPost post) {
        jdbcTemplate.update(SQL_UPDATE_BLOGPOST,
                post.getDate(),
                post.getTitle(),
                post.getImagePath(),
                post.getBlogText(),
                post.getIsApproved(),
                post.getBlogPostId());
        deleteBlogPostTags(post);
        deleteBlogPostCategories(post);
        insertBlogPostTags(post);
        insertBlogPostCategories(post);
    }

    @Override
    public void deleteBlogPost(int blogPostId) {
        jdbcTemplate.update(SQL_DELETE_BLOGPOST_CATEGORIES, blogPostId);
        jdbcTemplate.update(SQL_DELETE_BLOGPOST_TAGS, blogPostId);
        jdbcTemplate.update(SQL_DELETE_BLOGPOST, blogPostId);
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_BLOGPOST, new blogPostMapper());
    }
    
    @Override
    public List<BlogPost> getAllBlogPosts_WithSummary() {
        return jdbcTemplate.query(SQL_SELECT_ALL_BLOGPOST_SUMMARY, new blogPostMapper());
    }
    
    @Override
    public List<BlogPost> getAllApprovedBlogPosts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_APPROVED_BLOGPOSTS, new blogPostMapper());
    }

    @Override
    public List<BlogPost> getAllBlogPostsByDate(int monthInt, int year) {
        return jdbcTemplate.query(SQL_SELECT_ALL_BLOGPOST_BY_DATE, new blogPostMapper(), monthInt, year);
    }

    @Override
    public List<BlogPost> getAllBlogPostsByCategoryId(int categoryId) {
       return jdbcTemplate.query(SQL_SELECT_ALL_BLOGPOST_BY_CATEGORY, new blogPostMapper(), categoryId);
    }

    @Override
    public List<BlogPost> getAllBlogPostsByTagId(int tagId) {
       return jdbcTemplate.query(SQL_SELECT_ALL_BLOGPOST_BY_TAG, new blogPostMapper(), tagId);
    }
    
    @Override
    public List<BlogPost> searchBlogPostsByKeyword(String searchCriteria) {
        searchCriteria = "%" + searchCriteria + "%";
        return jdbcTemplate.query(SQL_SEARCH_BLOGPOST_BY_KEYWORD, new blogPostMapper(), searchCriteria, searchCriteria);
    }
    
    @Override
    public List<Integer> getAllTagIdsByBlogPostId(int blogPostId) {
        return jdbcTemplate.query(SQL_SELECT_BLOGPOST_TAG_IDS_BY_BLOGPOST_ID, new tagIdMapper(), blogPostId);
    }
    
    @Override
    public List<Integer> getAllCategoryIdsByBlogPostId(int blogPostId) {
        return jdbcTemplate.query(SQL_SELECT_BLOGPOST_CATEGORY_IDS_BY_BLOGPOST_ID, new categoryIdMapper(), blogPostId);
    }
    
    @Override
    public List<Integer> getAllUniqueYears() {
        // get the list of unique blogPost years
        List<Integer> uniqueYears = jdbcTemplate.queryForList(SQL_SELECT_ALL_UNIQUE_YEARS, Integer.class);
        return uniqueYears;
    }
    
    @Override
    public Map<Integer, List<String>> getAllUniqueYearMonths() {
        
        // create map that will have year as key and months as values
        TreeMap<Integer, List<String>> yearMonthsMap = new TreeMap<>();

        // get the list of unique blogPost years to be used as reference for sorting months       
        List<Integer> yearList = getAllUniqueYears();

        // get SQL Year-Month results in form of year:month (ie. "2016:November")
        List<String> uniqueYearMonths_SqlResult = jdbcTemplate.queryForList(SQL_SELECT_ALL_UNIQUE_YEAR_MONTHS, String.class);
   
        // for loop to separate year:month string and then store in hashMap based on year        
        for (int year : yearList) {
            
            List<String> monthList = new ArrayList<>();
            
            for (String entry : uniqueYearMonths_SqlResult) {
                // split each year:month String to (ie.) ["2016", "November"]
                String[] currentYearMonthArray = entry.split(":");
                Integer currentYear = Integer.parseInt(currentYearMonthArray[0]);
                String currentMonth = currentYearMonthArray[1];
                
                if (currentYear == year) {
                    monthList.add(currentMonth);
                }
            }
            yearMonthsMap.put(year, monthList);
        }
        
        
        return yearMonthsMap.descendingMap();
    }
    
    @Override
    public List<BlogPost> getAllBlogPosts_LimitedInformation() {
        return jdbcTemplate.query(SQL_SELECT_ALL_BLOGPOST_LIMITED_INFO, new blogPostMapperLimited());
    }
    
    @Override
    public void approveBlogPost(int blogPostId) {
        jdbcTemplate.update(SQL_APPROVE_BLOGPOST, blogPostId);        
    }
    
    @Override
    public void unapproveBlogPost(int blogPostId) {
        jdbcTemplate.update(SQL_UNAPPROVE_BLOGPOST, blogPostId);        
    }
    
    private static final class blogPostMapper implements RowMapper<BlogPost> {

        public BlogPost mapRow(ResultSet rs, int i) throws SQLException {
            BlogPost bp = new BlogPost();
            bp.setTitle(rs.getString("title"));
            bp.setDate(rs.getString("date"));
            bp.setImagePath(rs.getString("imagePath"));
            bp.setBlogText(rs.getString("blogText"));
            bp.setBlogPostId(rs.getInt("blogpostId"));
            bp.setIsApproved(rs.getInt("isApproved"));
            return bp;
        }

    }
    
        private static final class blogPostMapperLimited implements RowMapper<BlogPost> {

        public BlogPost mapRow(ResultSet rs, int i) throws SQLException {
            BlogPost bp = new BlogPost();
            bp.setTitle(rs.getString("title"));
            bp.setDate(rs.getString("date"));
            bp.setBlogPostId(rs.getInt("blogpostId"));
            bp.setIsApproved(rs.getInt("isApproved"));
            return bp;
        }

    }

    private static final class categoryIdMapper implements RowMapper<Integer> {

        public Integer mapRow(ResultSet rs, int i) throws SQLException {
            return Integer.parseInt(rs.getString("categoryId"));
        }

    }
    
    private static final class tagIdMapper implements RowMapper<Integer> {

        public Integer mapRow(ResultSet rs, int i) throws SQLException {
            return Integer.parseInt(rs.getString("tagId"));
        }

    }
}
