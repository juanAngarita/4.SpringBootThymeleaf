package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;

// Repositorio encargado de realizar las operaciones con la base de datos
@Repository
public class StudentRepository {

    // Base de datos falsa
    private Map<Integer, Student> data = new HashMap<>();

    // Cosntructor
    public StudentRepository() {
        data.put(1, new Student(1, "Juan", "Sistemas", 2, "pepe@pe.com",
                "https://avatars.githubusercontent.com/u/1561955?v=4"));
        data.put(2, new Student(2, "Miguel", "Mecanica", 10, "miguel@pe.com",
                "https://avatars.githubusercontent.com/u/1561955?v=4"));
        data.put(3, new Student(3, "Andres", "Filosofia", 3, "andres@pe.com",
                "https://avatars.githubusercontent.com/u/1561955?v=4"));
        data.put(4, new Student(4, "Laura", "Artes", 10, "laura@pe.com",
                "https://avatars.githubusercontent.com/u/1561955?v=4"));
    }

    // Metodos CRUD, después se reemplazará por JPA
    public Student findById(Integer id) {
        return data.get(id);
    }

    public Collection<Student> findAll() {
        return data.values();
    }

    public void save(Student student) {
        if (student.getId() == null) {
            int tam = data.size();
            int lastId = data.get(tam).getId();
            student.setId(lastId + 1);
            data.put(student.getId(), student);
        } else {
            data.put(student.getId(), student);
        }
    }

    public void delete(Integer id) {
        data.remove(id);
    }

    public Collection<Student> findByNombre (String nombre) {
        Collection<Student> result = new java.util.ArrayList<>();
        for (Student student : data.values()) {
            if (student.getNombre().equals(nombre)) {
                result.add(student);
            }
        }
        return result;
    } 

}
