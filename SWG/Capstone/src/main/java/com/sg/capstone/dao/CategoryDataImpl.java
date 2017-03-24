/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.Category;
import com.sg.capstone.model.Tag;
import com.sg.capstone.model.ops.ListOps;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class CategoryDataImpl implements CategoryDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_CATEGORY = "insert ignore into categories (name) values(?) ";
    private static final String SQL_DELETE_CATEGORY = "delete from categories where categoryId = ?  ";
    private static final String SQL_SELECT_ALL_CATEGORIES = "select * from categories";
    private static final String SQL_SELECT_DISTINCT_CATEGORIES = "select distinct `name` from categories";
    private static final String SQL_SELECT_CATEGORY_BY_ID = "select * from categories where categoryId = ?";
    private static final String SQL_SELECT_ALL_ACTIVE_CATEGORY_IDS = "select distinct categoryId from blogPost_categories bpc " +
            "join blogPost bp on bpc.blogPostId = bp.blogPostId where bp.isApproved = 1";

    private static final String SQL_SELECT_BLOGPOST_CATEGORY_IDS_BY_BLOGPOST_ID = "select categoryId from blogPost_categories where blogPostId = ?";

    @Override
    public boolean addCategory(Category category) {
        // If a category with this name does not already exist... then add it
        if (!ListOps.getCategoryNamesFromList(getAllCategories()).contains(category.getName())) {
            jdbcTemplate.update(SQL_INSERT_CATEGORY, category.getName());
            category.setCategoryId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
            return true;
        }
        return false;
    }

    @Override
    public List<Category> addCategoriesFromString(String categoryString) {
        List<String> categoryNameList = ListOps.createListFromString(categoryString);
        List<Category> categoryList = new ArrayList<>();
        for (String categoryName : categoryNameList) {
            Category category = new Category();
            category.setName(categoryName);
            if (!addCategory(category)) {
                List<Category> allCategories = getAllCategories();
                for (Category c : allCategories) {
                    if (c.getName().equals(category.getName())) {
                        category = c;
                    }
                }
            }
            categoryList.add(category);
        }
        return categoryList;
    }

    @Override
    public void deleteCategory(int categoryId) {
        jdbcTemplate.update(SQL_DELETE_CATEGORY, categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return jdbcTemplate.query(SQL_SELECT_ALL_CATEGORIES, new categoryMapper());
    }

    @Override
    public List<Category> getAllActiveCategories() {
        List<Integer> activeCategoryIds = jdbcTemplate.query(SQL_SELECT_ALL_ACTIVE_CATEGORY_IDS, new categoryIdMapper());
        List<Category> activeCategories = new ArrayList<>();
        for (Integer i : activeCategoryIds) {
            activeCategories.add(getCategoryById(i));
        }
        return activeCategories;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        try {
            Category category = jdbcTemplate.queryForObject(SQL_SELECT_CATEGORY_BY_ID, new categoryMapper(), categoryId);
            return category;
        } catch (EmptyResultDataAccessException e) {       
            return null;
        }
    }

    private static final class categoryMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int i) throws SQLException {
            Category category = new Category();
            category.setCategoryId(rs.getInt("categoryId"));
            category.setName(rs.getString("name"));
            return category;
        }
    }

    private static final class categoryIdMapper implements RowMapper<Integer> {

        public Integer mapRow(ResultSet rs, int i) throws SQLException {
            return Integer.parseInt(rs.getString("categoryId"));
        }

    }

}
