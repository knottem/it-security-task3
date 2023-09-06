package com.example.demo.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentInfo {
    private Student student;
    private Pii pii;
    private List<Grade> grades;
    private List<Activity> activities;
}
