package com.hexaware.service;

import com.hexaware.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	// Normalize username (optional but helps avoid case or space issues)
        String normalizedUsername = username.trim().toLowerCase();

        // Find user from DB or throw error if not found
        User user = userRepo.findByUsername(normalizedUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + normalizedUsername));

        // Return a Spring Security user object
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword()) // already encrypted (BCrypt)
                .roles(user.getRole() != null ? user.getRole().toUpperCase() : "USER")
                .build();
    }
}

