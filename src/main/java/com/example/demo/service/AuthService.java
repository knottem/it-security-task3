package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.Auth;
import com.example.demo.repository.AuthRepository;

import java.util.Base64;

@Service
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AuthRepository authRepository;

    public boolean authenticate(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Basic")) {
            String base64Credentials = authHeader.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            // credentials = username:password
            final String[] values = credentials.split(":", 2);

            String username = values[0];
            String password = values[1];

            logger.info("Försöker autentisera med användarnamn: {} och lösenord: {}", username, password);

            if ("admin".equals(username) && "supersecret".equals(password)) {
                return true;

            }

            Auth auth = authRepository.findByUsername(username);
            logger.debug("Jämför med lösenord: {}", auth.getPassword());

            if (auth != null && auth.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }
}
