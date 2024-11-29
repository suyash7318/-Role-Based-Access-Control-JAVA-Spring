package com.codewithprojects.springsecurity.services.impl;

import com.codewithprojects.springsecurity.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDetailsService userDetailsService;

    // Constructor injection for UserDetailsService
    public UserServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
}
