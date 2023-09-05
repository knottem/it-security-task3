package com.example.demo.service;

import com.example.demo.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.demo.data.Auth;

import java.util.ArrayList;

public class AuthDetailService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Auth auth = authRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Auth not found with username: " + username));
        return new org.springframework.security.core.userdetails.User(auth.getUsername(), auth.getPassword(), new ArrayList<>());
    }
}
