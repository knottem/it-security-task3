package com.example.demo.data;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class Activity {
    @Id
    private int activityId;
    private int studentId;
    private String activityName;
}