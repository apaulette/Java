/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.Tag;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface TagDao {
    
    public boolean addTag(Tag tag);
    
    public void deleteTag(int tagId);
    
    public List<Tag> getAllTags();
    
    public Tag getTagById(int tagId);
    
    public List<Tag> addTagsFromString(String tagString);
}
