package com.example.lab05_q1.Controller;

import com.example.lab05_q1.ApiResponse.ApiResponse;
import com.example.lab05_q1.Model.Student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    ArrayList<Student> students = new ArrayList<>();

    //• Display all students.
    @GetMapping("/display")
    public ArrayList<Student> display(){
        return students;
    }

    //• Create a new student (ID, name, age, degree, GPA)
    @PostMapping("/create")
    public ApiResponse createStudent(@RequestBody Student student){
        students.add(student);
        return new ApiResponse("A new student is created!");
    }

    //• Update a student
    @PutMapping("/update/{id}")
    public ApiResponse updateStudent(@PathVariable int id,@RequestBody Student student){
        for (int index=0;index<students.size();index++) {
            if (student.getId()==id) {
                students.set(index, student);
                return new ApiResponse("Updated!!");
            }
        }
        return new ApiResponse("student not found...");
    }

    //• Delete a student
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteStudent(@PathVariable int id){
        for (int index=0;index<students.size();index++) {
            if (students.get(index).getId()==id) {
                students.remove(index);
                return new ApiResponse("Deleted!!");
            }
        }
        return new ApiResponse("student not found...");
    }

    //• Based on GPA, classify students into honors categories.
    @GetMapping("/honors")
    public ArrayList<Student> honors() {
        Student max = students.get(0);
        Student min = students.get(0);
        Student temp;
        ArrayList<Student> honors = new ArrayList<>();
        for (Student s : students) {
            if (s.getGpa() >= max.getGpa()) {
                honors.add(0, s);
                max = s;
            }
        }
        return honors;
    }

    //• Display a group of students whose GPA is greater than the average GPA.
    @GetMapping("/average-gpa")
    public ArrayList<Student> averageGpa(){
        ArrayList<Student> students1 = new ArrayList<>();
        double average = students.size();
        double sum = 0;
        for(Student s : students){
            sum += s.getGpa();
        }
        average = sum/average;
        for (Student s2:students){
            if (s2.getGpa()>average)
                students1.add(s2);
        }
        return students1;
    }

}
