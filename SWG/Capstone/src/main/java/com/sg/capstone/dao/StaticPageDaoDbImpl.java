/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.StaticPage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class StaticPageDaoDbImpl implements StaticPageDao {
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private static final String SQL_INSERT_STATICPAGE
            = "INSERT INTO staticPage (title, staticPageText, imagePath, displayOrder, isApproved) values (?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_STATICPAGE
            = "DELETE FROM staticPage WHERE staticPageId = ?";
    private static final String SQL_APPROVE_STATICPAGE
            = "UPDATE staticPage SET isApproved=1 WHERE staticPageId = ?;";
    private static final String SQL_UNAPPROVE_STATICPAGE
            = "UPDATE staticPage SET isApproved=0 WHERE staticPageId = ?;";
    private static final String SQL_UPDATE_STATICPAGE
            = "UPDATE staticPage SET title = ?, staticPageText = ?, imagePath = ?, displayOrder = ?, isApproved = ? WHERE staticPageId= ?";
    private static final String SQL_SELECT_STATICPAGE
            = "SELECT * FROM staticPage WHERE staticPageId=?";
    private static final String SQL_SELECT_ALL_STATICPAGE
            = "SELECT `staticPageId`, `title`, `displayOrder` FROM staticPage";    
    private static final String SQL_SELECT_STATICPAGE_DISPLAY_ASC
            = "SELECT * FROM staticPage ORDER BY `displayOrder` ASC";    
    private static final String SQL_UPDATE_STATICPAGE_DISPLAYORDER
            = "UPDATE staticPage SET displayOrder = ? WHERE staticPageId = ?";    

    @Override
    public void addStaticPage(StaticPage stpg) {
        jdbcTemplate.update(SQL_INSERT_STATICPAGE,
                stpg.getTitle(),
                stpg.getStaticPageText(),
                stpg.getImagePath(),
                stpg.getDisplayOrder(),
                stpg.getIsApproved());
        stpg.setStaticPageId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public StaticPage getStaticPageById(int staticPageId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_STATICPAGE, new staticPageMapper(), staticPageId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void updateStaticPage(StaticPage stpg) {
        jdbcTemplate.update(SQL_UPDATE_STATICPAGE,
                stpg.getTitle(),
                stpg.getStaticPageText(),
                stpg.getImagePath(),
                stpg.getDisplayOrder(),
                stpg.getIsApproved(),
                stpg.getStaticPageId());
    }

    @Override
    public void updateStaticPageDisplayOrder(StaticPage stpg) {
        jdbcTemplate.update(SQL_UPDATE_STATICPAGE_DISPLAYORDER,
                stpg.getDisplayOrder(),
                stpg.getStaticPageId());
    }

    @Override
    public void deleteStaticPage(int staticPageId) {
        jdbcTemplate.update(SQL_DELETE_STATICPAGE, staticPageId);
    }

    @Override
    public void approveStaticPage(int staticPageId) {
        jdbcTemplate.update(SQL_APPROVE_STATICPAGE, staticPageId);
    }

    @Override
    public void unapproveStaticPage(int staticPageId) {
        jdbcTemplate.update(SQL_UNAPPROVE_STATICPAGE, staticPageId);
    }

    @Override
    public List<StaticPage> getAllStaticPageLinks() {
        return jdbcTemplate.query(SQL_SELECT_STATICPAGE_DISPLAY_ASC, new staticPageMapper());
    }

    private static final class staticPageMapper implements RowMapper<StaticPage> {

        public StaticPage mapRow(ResultSet rs, int i) throws SQLException {
            StaticPage stpgMap = new StaticPage();
            stpgMap.setStaticPageId(rs.getInt("staticPageId"));
            stpgMap.setTitle(rs.getString("title"));
            stpgMap.setStaticPageText(rs.getString("staticPageText"));
            stpgMap.setImagePath(rs.getString("imagePath"));
            stpgMap.setDisplayOrder(rs.getInt("displayOrder"));
            stpgMap.setIsApproved(rs.getInt("isApproved"));
            return stpgMap;
        }

    }
}
