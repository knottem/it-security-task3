package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.data.*;

import java.util.List;

@Repository
public interface GradesRepository extends JpaRepository<Grade, Integer> {
    List<Grade> findByStudentId(Integer studentId);
}
