package com.example.demo.repository;

import java.util.List;
import java.util.Map;

public interface PiiRepository {

    List<Map<String, Object>> getPII(String studentId);

}
