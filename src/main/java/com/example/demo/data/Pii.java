package com.example.demo.data;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
public class Pii {
    @Id
    private int piiId;
    private int studentId;
    private String personnummer;
    private String phoneNumber;
    private byte[] biometricData;
}
