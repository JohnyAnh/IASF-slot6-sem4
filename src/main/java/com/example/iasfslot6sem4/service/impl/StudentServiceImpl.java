package com.example.iasfslot6sem4.service.impl;

import com.example.iasfslot6sem4.entity.Students;
import com.example.iasfslot6sem4.repository.StudentRepository;
import com.example.iasfslot6sem4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    //Vừa create vừa update
    public void saveStudent(Students students) {
        try {
            studentRepository.save(students);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Students findbyIdStudent(Integer id) {
        try {
            Optional<Students> optionalCustomer = studentRepository.findById(id);
            return optionalCustomer.orElse(null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Students> findbyStudent() {
        try {
            return studentRepository.findAll();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void deleteStudentById(Integer id) {
        try {
            studentRepository.delete(findbyIdStudent(id));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
