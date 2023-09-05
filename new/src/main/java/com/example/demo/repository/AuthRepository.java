package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.data.*;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {
    Auth findByUsername(String username);
}
