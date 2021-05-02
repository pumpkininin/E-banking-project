package com.se2.ebanking.utils;

import com.se2.ebanking.services.CustomerService;
import com.se2.ebanking.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    // Encryte Password with BCryptPasswordEncoder
    @Autowired
    private static UserDetailsServiceImpl userDetailsService;
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.encode(password);
    }
    public static Boolean doPasswordsMatch(String rawPassword,String encodedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, encodedPassword);
    }

    public static void main(String[] args) {
        String password = "nga210@";
        String encrytedPassword = encrytePassword("hieu15987532@");


        System.out.println("Encryted Password: " + encrytedPassword);


    }
}
