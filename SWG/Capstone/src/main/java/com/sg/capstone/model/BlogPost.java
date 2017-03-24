/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author apprentice
 */
public class BlogPost {
    
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private int blogPostId;
    private String title;
    private String date = dateFormat.format(new Date());
    private String imagePath;
    private String blogText;
    private ArrayList<Integer> categoryIds;
    private ArrayList<Integer> tagIds;
    private String categoryString;
    private String tagString;
    private int isApproved;

    /**
     * @return the blogPostId
     */
    public int getBlogPostId() {
        return blogPostId;
    }

    /**
     * @param blogPostId the blogPostId to set
     */
    public void setBlogPostId(int blogPostId) {
        this.blogPostId = blogPostId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * @return the blogText
     */
    public String getBlogText() {
        return blogText;
    }

    /**
     * @param blogText the blogText to set
     */
    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    /**
     * @return the categoryIds
     */
    public ArrayList<Integer> getCategoryIds() {
        return categoryIds;
    }

    /**
     * @param categoryIds the categoryIds to set
     */
    public void setCategoryIds(ArrayList<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    /**
     * @return the tagIds
     */
    public ArrayList<Integer> getTagIds() {
        return tagIds;
    }

    /**
     * @param tagIds the tagIds to set
     */
    public void setTagIds(ArrayList<Integer> tagIds) {
        this.tagIds = tagIds;
    }

    /**
     * @return the categoryString
     */
    public String getCategoryString() {
        return categoryString;
    }

    /**
     * @param categoryString the categoryString to set
     */
    public void setCategoryString(String categoryString) {
        this.categoryString = categoryString;
    }

    /**
     * @return the tagString
     */
    public String getTagString() {
        return tagString;
    }

    /**
     * @param tagString the tagString to set
     */
    public void setTagString(String tagString) {
        this.tagString = tagString;
    }

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }
    
}
