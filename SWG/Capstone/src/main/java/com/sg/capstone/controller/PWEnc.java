/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.controller;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PWEnc {

    public static void main(String[] args) {
        String[] passwords = {"adminpassword", "password"};
        for (String clearTxtPw : passwords) {
            // BCrypt
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashedPw = encoder.encode(clearTxtPw);
            System.out.println(clearTxtPw + "::" + hashedPw);
        }
    }
}
