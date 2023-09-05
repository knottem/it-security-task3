package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.data.Auth;
import com.example.demo.repository.AuthRepository;

import java.util.Base64;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private AuthRepository authRepository;

    @Test
    public void testDefaultAuthenticate() {
        // Testar med admin-autentisering
        String base64Credentials = Base64.getEncoder().encodeToString("admin:supersecret".getBytes());
        assertTrue(authService.authenticate("Basic " + base64Credentials));
    }

    @Test
    public void testStudentAuthenticate() {
        // Förbereder mock-objektet
        Auth mockAuth = new Auth();
        mockAuth.setUsername("testUser");
        mockAuth.setPassword("testPass");

        Mockito.when(authRepository.findByUsername("testUser")).thenReturn(mockAuth);

        // Testar med admin-autentisering
        String base64Credentials = Base64.getEncoder().encodeToString("testUser:testPass".getBytes());
        assertTrue(authService.authenticate("Basic " + base64Credentials));
    }
}
