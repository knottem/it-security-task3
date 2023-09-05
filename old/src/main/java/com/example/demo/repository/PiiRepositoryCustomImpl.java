package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class PiiRepositoryCustomImpl implements PiiRepository {

    @Autowired
    private EntityManager entityManager;

    // what about 1 or 1 = 1 --
    public List<Map<String, Object>> getPII(String studentId) {
        String sql = "SELECT * FROM pii WHERE student_id = " + studentId;
        List<Map<String, Object>> results = new ArrayList<>();

        // Run the query
        Query query = entityManager.createNativeQuery(sql);
        List<Object[]> rows = query.getResultList();

        // Map rows to your objects (if needed)
        for (Object[] row : rows) {
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("column1", row[0]);
            resultMap.put("column2", row[1]);
            resultMap.put("column3", row[2]);
            resultMap.put("column4", row[3]);
            resultMap.put("column5", row[4]);
            results.add(resultMap);
        }

        return results;
    }
}
