package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.*;
import com.example.demo.repository.*;
import com.example.demo.service.AuthService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AuthService authService;

    @Autowired
    private CustomStudentRepository customStudentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private PiiRepository piiRepository;

    // Test Case 1: Data Access - Student
    @GetMapping("/students")
    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/search/pii")
    public List<Map<String, Object>> getStudentByStudentId(@RequestHeader(value = "Authorization") String authHeader,
            @RequestParam String studentId) throws Exception {
        if (authService.authenticate(authHeader)) {
            return piiRepository.getPII(studentId);
        }
        throw new Exception("Not authenticated");

    }

    // Test Case 2: Show Course List
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    // Test Case 3: Search - Student
    @GetMapping("/search/student")
    public List<Student> searchStudent(@RequestParam String name) {
        return studentRepository.findByName(name);

    }

    // Test Case 4: Search - Course
    @GetMapping("/search/course")
    public List<Course> searchCourse(@RequestParam String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    // Test Case: List all students with health data
    @GetMapping("/students/health")
    public List<StudentWithHealthRecord> getAllStudentsWithHealthData() {
        List<StudentWithHealthRecord> data = customStudentRepository.findAllStudentsWithHealthRecord();
        System.out.println(data);
        return data;
    }

    // Test Case: List all student passwords
    @GetMapping("/students/passwords")
    public List<Auth> getAllStudentPasswords() {
        return authRepository.findAll();
    }
}
