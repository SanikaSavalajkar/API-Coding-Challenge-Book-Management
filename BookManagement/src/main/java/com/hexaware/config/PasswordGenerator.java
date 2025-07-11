package com.hexaware.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        String rawPassword = "admin123";
        String encryptedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        System.out.println("Encrypted password: " + encryptedPassword);
    }
}