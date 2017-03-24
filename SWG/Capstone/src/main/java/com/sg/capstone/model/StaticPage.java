/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.model;

/**
 *
 * @author apprentice
 */
public class StaticPage {
    
    private int staticPageId;
    private String title;
    private String staticPageText;
    private String imagePath;
    private int isApproved;
    private int displayOrder;

    /**
     * @return the staticPageId
     */
    public int getStaticPageId() {
        return staticPageId;
    }

    /**
     * @param staticPageId the staticPageId to set
     */
    public void setStaticPageId(int staticPageId) {
        this.staticPageId = staticPageId;
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
     * @return the staticPageText
     */
    public String getStaticPageText() {
        return staticPageText;
    }

    /**
     * @param staticPageText the staticPageText to set
     */
    public void setStaticPageText(String staticPageText) {
        this.staticPageText = staticPageText;
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

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
    
}
