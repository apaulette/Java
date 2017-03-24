/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.model.ops;

import com.sg.capstone.model.Category;
import com.sg.capstone.model.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ListOps {
    
    public static List<String> createListFromString(String s) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> stringList = new ArrayList<>();
        String[] stringArray = s.split(",");
        for (String string : stringArray) {
            // Trim leading and trailing whitespace off the strings
            string = string.trim();
            // Only add the string if it isn't already in the list
            if (!stringList.contains(string)) {
                stringList.add(string);
            }
        }
        return stringList;
    }
    
    public static String createStringFromList(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s).append(",");
        }
        return builder.toString();
    }
    
    public static List<Integer> createTagIdListFromTagList(List<Tag> tagList) {
        List<Integer> tagIds = new ArrayList<>();
        for (Tag tag : tagList) {
            tagIds.add(tag.getTagId());
        }
        return tagIds;
    }
    
    public static List<Integer> createCategoryIdListFromCategoryList(List<Category> categoryList) {
        List<Integer> categoryIds = new ArrayList<>();
        for (Category category : categoryList) {
            categoryIds.add(category.getCategoryId());
        }
        return categoryIds;
    }
    
    public static List<String> getTagNamesFromList(List<Tag> tagList) {
        List<String> tagNames = new ArrayList<>();
        for (Tag tag : tagList) {
            tagNames.add(tag.getName());
        }
        return tagNames;
    }
    
    public static List<String> getCategoryNamesFromList(List<Category> categoryList) {
        List<String> categoryNames = new ArrayList<>();
        for (Category category : categoryList) {
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }
}
