package com.example.demo.repository;

import com.example.demo.data.Pii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PiiRepository extends JpaRepository<Pii, Integer> {
    List<Pii> findByStudentId(int studentId);
}
