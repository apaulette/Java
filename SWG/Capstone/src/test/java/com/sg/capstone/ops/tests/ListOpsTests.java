/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.ops.tests;

import com.sg.capstone.model.Category;
import com.sg.capstone.model.Tag;
import com.sg.capstone.model.ops.ListOps;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class ListOpsTests {
    
    public ListOpsTests() {
    }

    @Test
    public void testCreateListFromString() {
        String items = "   item1, item2  ,item3";
        List<String> itemStringList = ListOps.createListFromString(items);
        
        assertEquals("item1", itemStringList.get(0));
        assertEquals("item2", itemStringList.get(1));
        assertEquals("item3", itemStringList.get(2));
        assertEquals(3, itemStringList.size());
    }
    
    @Test
    public void testCreateStringFromList() {
        List<String> stringList = new ArrayList<>();
        
        stringList.add("item1");
        stringList.add("item2");
        stringList.add("item3");
        
        String string = ListOps.createStringFromList(stringList);
        
        assertEquals("item1,item2,item3,", string);
    }
    
    @Test
    public void testCreateTagIdListFromTagList() {
        List<Tag> tagList = new ArrayList<>();
        
        Tag tag1 = new Tag();
        tag1.setTagId(1);
        tagList.add(tag1);
        
        Tag tag2 = new Tag();
        tag2.setTagId(2);
        tagList.add(tag2);
        
        Tag tag3 = new Tag();
        tag3.setTagId(3);
        tagList.add(tag3);
        
        List<Integer> tagIdList = ListOps.createTagIdListFromTagList(tagList);
        
        assertEquals(3, tagIdList.size());
        assertTrue(tagIdList.get(0) == 1);
        assertTrue(tagIdList.get(1) == 2);
        assertTrue(tagIdList.get(2) == 3);
    }
    
    @Test
    public void testCreateCategoryIdListFromCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        
        Category category1 = new Category();
        category1.setCategoryId(1);
        categoryList.add(category1);
        
        Category category2 = new Category();
        category2.setCategoryId(2);
        categoryList.add(category2);
        
        Category category3 = new Category();
        category3.setCategoryId(3);
        categoryList.add(category3);
        
        List<Integer> categoryIdList = ListOps.createCategoryIdListFromCategoryList(categoryList);
        
        assertEquals(3, categoryIdList.size());
        assertTrue(categoryIdList.get(0) == 1);
        assertTrue(categoryIdList.get(1) == 2);
        assertTrue(categoryIdList.get(2) == 3);
    }
    
    @Test
    public void testGetTagNamesFromList() {
        List<Tag> tagList = new ArrayList<>();
        
        Tag tag1 = new Tag();
        tag1.setName("tag1");
        tagList.add(tag1);
        
        Tag tag2 = new Tag();
        tag2.setName("tag2");
        tagList.add(tag2);
        
        Tag tag3 = new Tag();
        tag3.setName("tag3");
        tagList.add(tag3);
        
        List<String> tagNames = ListOps.getTagNamesFromList(tagList);
        
        assertEquals("tag1", tagNames.get(0));
        assertEquals("tag2", tagNames.get(1));
        assertEquals("tag3", tagNames.get(2));
    }
    
    @Test
    public void testGetCategoryNamesFromList() {
        List<Category> categoryList = new ArrayList<>();
        
        Category category1 = new Category();
        category1.setName("category1");
        categoryList.add(category1);
        
        Category category2 = new Category();
        category2.setName("category2");
        categoryList.add(category2);
        
        Category category3 = new Category();
        category3.setName("category3");
        categoryList.add(category3);
        
        List<String> categoryNames = ListOps.getCategoryNamesFromList(categoryList);
        
        assertEquals("category1", categoryNames.get(0));
        assertEquals("category2", categoryNames.get(1));
        assertEquals("category3", categoryNames.get(2));
    }
}
