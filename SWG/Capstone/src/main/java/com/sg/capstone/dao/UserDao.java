/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.dao;

import com.sg.capstone.model.User;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface UserDao {
    
    public User addUser(User newUser);
    
    public void deleteUser(String userName);
    
    public User getUser(String userName);
    
    public List<User> getAllUsers();
            
    
}
