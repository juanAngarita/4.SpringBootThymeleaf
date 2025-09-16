package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Student {

    private Integer id;
    private String nombre;
    private String carrera;
    private int semestre;
    private String correo;
    private String imageUrl;

}
