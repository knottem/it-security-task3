package com.example.demo.data;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class HealthRecord {
    @Id
    private int recordId;
    private int studentId;
    private String medicalRecord;
}
