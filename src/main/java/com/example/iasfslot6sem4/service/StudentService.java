package com.example.iasfslot6sem4.service;


import com.example.iasfslot6sem4.entity.Students;

import java.util.List;

public interface StudentService {
    void saveStudent(Students students);

    Students findbyIdStudent(Integer id);

    List<Students> findbyStudent();

    void deleteStudentById(Integer id);

}
