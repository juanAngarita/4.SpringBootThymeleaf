package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repo;

    @Override
    public Student searchById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Student> searchAll() {
        return repo.findAll();
    }

    @Override
    public void save(Student student) {
        repo.save(student);
        // TODO Auto-generated method stub
    }

    @Override
    public void delete(Integer id) {
        repo.delete(id);

    }

}
