package com.example.iasfslot6sem4.repository;

import com.example.iasfslot6sem4.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students, Integer> {
}
