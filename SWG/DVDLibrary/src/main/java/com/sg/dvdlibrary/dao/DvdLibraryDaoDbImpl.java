package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Amanda Paulette <apaulette@gmail.com>
 */
public class DvdLibraryDaoDbImpl implements DvdLibraryDao {
    
// #1 - All SQL code is in the form of Prepared Statements
    private static final String SQL_INSERT_DVD
            = "INSERT INTO dvds (title, rating_us, release_date, director_name, studio_name, user_rating, user_comment, cover_art) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_DVD
            = "DELETE FROM dvds WHERE lib_id = ?";
    private static final String SQL_SELECT_DVD
            = "SELECT * FROM dvds WHERE lib_id = ?";
    private static final String SQL_UPDATE_DVD
            = "UPDATE dvds SET title = ?, rating_us = ?, release_date = ?, director_name = ?, studio_name = ?, user_rating = ?, user_comment = ?, cover_art = ? WHERE lib_id = ?";
    private static final String SQL_SELECT_ALL_DVDS
            = "SELECT * FROM dvds";    
    
    
// #2a - Declare JdbcTemplate reference - the instance will be handed to us by Spring
    private JdbcTemplate jdbcTemplate;
    
// #2b - We are using Setter Injection to direct Spring to hand us an instance of
// the JdbcTemplate (see the Spring Configuration section below for configuration
// details).
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }    

    @Override
// #3 - Wrap addContact in a transaction so the we are guaranteed to get the
// correct LAST_INSERT_ID for our row.
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Dvd addEntry(Dvd entry) {
        jdbcTemplate.update(SQL_INSERT_DVD,
            entry.getTitle(),
            entry.getRatingUS(),
            entry.getReleaseDate(),
            entry.getDirectorName(),
            entry.getStudioName(),
            entry.getUserRating(),
            entry.getUserComment(),
            entry.getCoverArt());
            entry.setLibId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return entry;
    }

    @Override
    public Dvd retrieveEntryById(int libId) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), libId);
        } catch (EmptyResultDataAccessException ex) {
            // there were no results for the given contact id - we just want to
            // return null in this case
            return null;
        }
    }

    @Override
    public List<Dvd> retrieveSortedEntries() {
        List <Dvd> allEntries = loadAllEntries();
        Collections.sort(allEntries);
        return allEntries;
    }

    @Override
    public List<Dvd> searchEntries(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateEntry(Dvd entry) {
        jdbcTemplate.update(SQL_UPDATE_DVD,
            entry.getTitle(),
            entry.getRatingUS(),
            entry.getReleaseDate(),
            entry.getDirectorName(),
            entry.getStudioName(),
            entry.getUserRating(),
            entry.getUserComment(),
            entry.getCoverArt(),
            entry.getLibId());
    }

    @Override
    public void deleteEntry(int libId) {
        jdbcTemplate.update(SQL_DELETE_DVD, libId);
    }

    @Override
// #4
    public List<Dvd> loadAllEntries() {
        return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());
    }    
    
// #5 - This class maps the columns in the 'contacts' table into properties on the
// Dvd object
    private static final class DvdMapper implements RowMapper<Dvd> {

        @Override
        public Dvd mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dvd entry = new Dvd();
            entry.setLibId(rs.getInt("lib_id"));
            entry.setTitle(rs.getString("title"));
            entry.setRatingUS(rs.getString("rating_us"));
            entry.setReleaseDate(rs.getString("release_date"));
            entry.setDirectorName(rs.getString("director_name"));
            entry.setStudioName(rs.getString("studio_name"));
            entry.setUserRating(rs.getInt("user_rating"));
            entry.setUserComment(rs.getString("user_comment"));
            entry.setCoverArt(rs.getString("cover_art"));
            return entry;
        }
    }
    
}