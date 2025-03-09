package com.example.lab05_q1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab05Q1Application {

	//Q1 : Create Spring program with request on the following endpoints :
	//Create a controller called studentController with the following endpoints.
	//Student Class: ID, name, age, degree, GPA.
	//• Create a new student (ID, name, age, degree, GPA)
	//• Display all students.
	//• Update a student
	//• Delete a student
	//• Based on GPA, classify students into honors categories.
	//• Display a group of students whose GPA is greater than the average GPA.

	public static void main(String[] args) {
		SpringApplication.run(Lab05Q1Application.class, args);
	}

}
