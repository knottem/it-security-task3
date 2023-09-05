package com.example.demo.data;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Data
@Entity
public class Grade {
    @Id
    private int gradeId;
    private int studentId;
    private int courseId;
    private String grade;
}
