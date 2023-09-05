package com.example.demo.data;

import lombok.Data;

@Data
public class StudentWithHealthRecord {

    private int studentId;
    private String name;
    private String medicalRecord;

    public StudentWithHealthRecord(int studentId, String name, String medicalRecord) {
        this.studentId = studentId;
        this.name = name;
        this.medicalRecord = medicalRecord;
    }

}