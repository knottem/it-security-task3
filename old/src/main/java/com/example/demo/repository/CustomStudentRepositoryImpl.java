package com.example.demo.repository;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.data.StudentWithHealthRecord;

@Repository
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<StudentWithHealthRecord> findAllStudentsWithHealthRecord() {
        String query = "SELECT s.student_id as studentId, s.name as name, h.medical_record as medicalRecord FROM Student s JOIN HealthRecord h ON s.student_id = h.student_id";

        List<StudentWithHealthRecord> studentWithHealthRecord = new ArrayList<>();
        List<Object[]> results = entityManager.createNativeQuery(query).getResultList();

        for (Object[] result : results) {
            StudentWithHealthRecord student = new StudentWithHealthRecord((int) result[0], (String) result[1],
                    (String) result[2]);
            studentWithHealthRecord.add(student);
        }
        return studentWithHealthRecord;
    }
}
