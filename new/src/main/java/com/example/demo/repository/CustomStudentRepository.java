package com.example.demo.repository;

import java.util.List;

import com.example.demo.data.*;

public interface CustomStudentRepository {
    List<StudentWithHealthRecord> findAllStudentsWithHealthRecord();
}
