package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entities.Student;

//@SpringBootApplication
@Configuration // declrar beans en este archivo
@EnableAutoConfiguration
@ComponentScan //
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// objetos
	@Bean
	public Student estudiante() {
		return new Student(2, "Perez2", "Sistemas2", 22, "pepe@pe.pe",
				"https://avatars.githubusercontent.com/u/1561955?v=4");
	}

	// objetos
	@Bean
	public Student estudiante2() {
		return new Student(3, "Perez3", "Sistemas3", 23, "pepe@pe.pe",
				"https://avatars.githubusercontent.com/u/1561955?v=4");
	}
}
