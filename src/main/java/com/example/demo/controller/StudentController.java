package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;

@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    private Student estudiante2;

    // Conexión con el servicio, NO SALTARSE CAPAS
    @Autowired
    StudentService service;

    // Logger ayuda a identificar errores de manera sencilla
    // Mas sencillo que usar System.out
    Logger log = LoggerFactory.getLogger(StudentController.class);

    // http://localhost:8080/student
    @GetMapping()
    public String mostrarEstudiantes(Model model) {
        model.addAttribute("estudiantes", service.searchAll());
        return "mostrar_todos_estudiantes";
    }

    // http://localhost:8080/student/1
    @GetMapping("/{id}")
    public String mostrarEstudiantePorId(Model model, @PathVariable("id") Integer identificacion) {

        Student student = service.searchById(identificacion);

        model.addAttribute("estudiante", student);

        return "mostrar_estudiante";
    }

    // http://localhost:8080/student/delete/1
    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/student";
    }

    // http://localhost:8080/student/add
    @GetMapping("/add")
    public String mostrarFormularioCrear(Model model) {

        Student student = new Student(null, "", "", 0, "", "");

        model.addAttribute("estudiante", student);

        return "crear_estudiante";
    }

    // http://localhost:8080/student/update/1
    @GetMapping("/update/{id}")
    public String getMethodName(@PathVariable("id") Integer id, Model model) {
        Student student = service.searchById(id);

        model.addAttribute("estudiante", student);

        return "crear_estudiante";
    }

    // http://localhost:8080/student/add
    @PostMapping("/add")
    public String agregarEstudiante(@ModelAttribute("estudiante") Student student) {

        log.info(student.getId() + " - " + student.getNombre());

        service.save(student);

        return "redirect:/student";
    }

    // nuevo
    @GetMapping(params = "nombre")
    public String buscarEstudiantesPorNombre(@RequestParam String nombre, Model model) {
        model.addAttribute("estudiantes", service.findByNombre(nombre));

        return "mostrar_todos_estudiantes";
    }
    

}
