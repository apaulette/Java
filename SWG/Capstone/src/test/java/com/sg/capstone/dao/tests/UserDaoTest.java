/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao.tests;

import com.sg.capstone.dao.UserDao;
import com.sg.capstone.model.User;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author apprentice
 */
public class UserDaoTest {
    
    private UserDao userDao;
    
    public UserDaoTest(){
    }
    
    User[] TestUsers=new User[3];
    
    @Before
    public void setup(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        userDao=(UserDao)ctx.getBean("userDao");
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from authorities");
        cleaner.execute("delete from user");
        
        ArrayList<String> testAuthoritiesList= new ArrayList<>();
        testAuthoritiesList.add("ADMIN");
        testAuthoritiesList.add("MODERATOR");
        
        
        User user1=new User();
        user1.setUsername("TestName1");
        user1.setPassword("Password1");
        user1.setAuthorities(testAuthoritiesList);
      
        User user2=new User();
        user2.setUsername("TestName2");
        user2.setPassword("Password2");
        user2.setAuthorities(testAuthoritiesList);
        
        User user3=new User();
        user3.setUsername("TestName3");
        user3.setPassword("Password3");
        user3.setAuthorities(testAuthoritiesList);
 
        TestUsers[0]=user1;
        TestUsers[1]=user2;
        TestUsers[2]=user3;
    }
    /*
    @Test
    public void UserIntegrationTest(){
        
        User controlUser1 = TestUsers[0];
        User controlUser2 = TestUsers[1];
        User controlUser3 = TestUsers[2];
        
        userDao.addUser(controlUser1);
        userDao.addUser(controlUser2);
        userDao.addUser(controlUser3);
        
        User userFromDb1 = userDao.getUser(controlUser1.getUsername());
        User userFromDb2 = userDao.getUser(controlUser1.getUsername());
        User userFromDb3 = userDao.getUser(controlUser1.getUsername());
        
        assertEquals(controlUser1.getUsername(), userFromDb1.getUsername());
        assertEquals(controlUser2.getUsername(), userFromDb2.getUsername());
        assertEquals(controlUser3.getUsername(), userFromDb3.getUsername());
        
        assertEquals(6, userDao.getAllUsers().size());
        
        userDao.deleteUser("TestName1");
        userDao.deleteUser("TestName2");
        userDao.deleteUser("TestName3");
        
        assertNull(userDao.getUser("TestName1"));
        assertNull(userDao.getUser("TestName2"));
        assertNull(userDao.getUser("TestName3"));
        
        assertEquals(0, userDao.getAllUsers().size());
        
    }
    */
    
    @After
    public void TearDown(){
    }
    
    
}
