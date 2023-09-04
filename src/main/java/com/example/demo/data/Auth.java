package com.example.demo.data;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class Auth {
    @Id
    private int studentId;
    private String username;
    private String password;
}