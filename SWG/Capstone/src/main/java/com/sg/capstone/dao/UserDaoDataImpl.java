/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.User;
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
public class UserDaoDataImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_USER = "insert into user (username, password, enabled) values (?, ?, 1)";
    private static final String SQL_INSERT_AUTHORITY = "insert into authorities(username, authority) values (?, ?)";
    private static final String SQL_DELETE_USER = "delete from user where username = ?";
    private static final String SQL_DELETE_AUTHORITY = "delete from authorities where username = ?";
    private static final String SQL_SELECT_USER = "SELECT user.userId, user.username, authorities.authority from user where username = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT user.userId, user.username, authorities.authority "
            + "FROM user JOIN authorities ON user.username = authorities.username";

    @Override
    public User addUser(User newUser) {
        jdbcTemplate.update(SQL_INSERT_USER, newUser.getUsername(), newUser.getPassword());
        newUser.setUserId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        ArrayList<String> authorities = newUser.getAuthorities();
        for (String authority : authorities) {
            jdbcTemplate.update(SQL_INSERT_AUTHORITY, newUser.getUsername(), authority);
        }
        return newUser;
    }

    @Override
    public void deleteUser(String username) {
        jdbcTemplate.update(SQL_DELETE_AUTHORITY, username);
        jdbcTemplate.update(SQL_DELETE_USER, username);
    }

    @Override
    public User getUser(String userName) {
        try {
            User user = jdbcTemplate.queryForObject(SQL_SELECT_USER, new userMapper(), userName);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, new userMapper());
    }

    private static final class userMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("userId"));
            user.setUsername(rs.getString("username"));
            user.setAuthority(rs.getString("authority"));
            return user;
        }

    }

}
