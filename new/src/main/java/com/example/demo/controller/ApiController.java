package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.*;
import com.example.demo.repository.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private PiiRepository piiRepository;
    @Autowired
    private GradesRepository gradeRepository;
    @Autowired
    private ActivityRepository activityRepository;

    // Test Case 1: Data Access - Student
    @GetMapping("/student/fullinfo")
    public ResponseEntity<StudentInfo> getFullStudentInfo(@RequestParam Integer studentId) {
        return ResponseEntity.ok(StudentInfo.builder()
                .student(studentRepository.findById(studentId).orElse(null))
                .pii(piiRepository.findByStudentId(studentId).stream().findFirst().orElse(null))
                .grades(gradeRepository.findByStudentId(studentId))
                .activities(activityRepository.findByStudentId(studentId))
                .build());
    }
    @GetMapping("/students")
    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/search/pii")
    public List<Pii> getStudentByStudentId(@RequestParam String studentId) {
        return piiRepository.findByStudentId(Integer.parseInt(studentId));
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
}
