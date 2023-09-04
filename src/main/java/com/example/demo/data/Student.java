package com.example.demo.data;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    private int studentId;
    private String name;
    private String gender;
}