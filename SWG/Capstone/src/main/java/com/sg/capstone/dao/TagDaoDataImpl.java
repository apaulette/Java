/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.BlogPost;
import com.sg.capstone.model.Category;
import com.sg.capstone.model.Tag;
import com.sg.capstone.model.ops.ListOps;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author apprentice
 */
public class TagDaoDataImpl implements TagDao {

    private JdbcTemplate jdbcTemplate;

    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_TAG = "insert into tags (name) values (?) ";
    private static final String SQL_DELETE_TAG = "delete from tags where tagId = ? ";
    private static final String SQL_SELECT_TAG_BY_ID = "select t.tagId, `name`, count(*) AS `count` "
            + "from blogPost_tags bpt join tags t on bpt.tagId = t.tagId where t.tagId = ? group by `name` order by t.tagId asc";
    private static final String SQL_SELECT_ALL_TAGS = "select t.tagId, `name`, count(*) AS `count` "
            + "from blogPost_tags bpt join tags t on bpt.tagId = t.tagId "
            + "join blogPost bp on bpt.blogPostId = bp.blogPostId where bp.isApproved = 1 group by `name` order by t.tagId asc";

    @Override
    public boolean addTag(Tag tag) {
        // If a tag with this name does not already exist... then add it
        if (!ListOps.getTagNamesFromList(getAllTags()).contains(tag.getName())) {
            jdbcTemplate.update(SQL_INSERT_TAG, tag.getName());
            tag.setTagId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
            return true;
        }
        return false;
    }

    @Override
    public List<Tag> addTagsFromString(String tagString) {
        List<String> tagNameList = ListOps.createListFromString(tagString);
        List<Tag> tagList = new ArrayList<>();
        for (String tagName : tagNameList) {
            Tag tag = new Tag();
            tag.setName(tagName);
            if (!addTag(tag)) {
                List<Tag> allTags = getAllTags();
                for (Tag t : allTags) {
                    if (t.getName().equals(tag.getName())) {
                        tag = t;
                    }
                }
            }
            tagList.add(tag);
        }
        return tagList;
    }

    @Override
    public void deleteTag(int tagId) {
        jdbcTemplate.update(SQL_DELETE_TAG, tagId);
    }

    @Override
    public List<Tag> getAllTags() {
        return jdbcTemplate.query(SQL_SELECT_ALL_TAGS, new tagMapper());
    }

    @Override
    public Tag getTagById(int tagId) {
        try {
            Tag tag = jdbcTemplate.queryForObject(SQL_SELECT_TAG_BY_ID, new tagMapper(), tagId);
            return tag;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private static final class tagMapper implements RowMapper<Tag> {

        @Override
        public Tag mapRow(ResultSet rs, int i) throws SQLException {
            Tag tag = new Tag();
            tag.setName(rs.getString("name"));
            tag.setTagId(rs.getInt("tagId"));
            tag.setCount(rs.getInt("count"));
            return tag;
        }
    }

}
