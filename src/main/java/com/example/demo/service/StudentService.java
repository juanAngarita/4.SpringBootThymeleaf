package com.example.demo.service;

import java.util.Collection;

import com.example.demo.entities.Student;

public interface StudentService {

    public Student searchById(Integer id);

    public Collection<Student> searchAll();

    public void save(Student student);

    public void delete(Integer id);

}
