package com.demo.example.Student_Library_Management_System.controller;


import com.demo.example.Student_Library_Management_System.dto.StudentRequestDto;
import com.demo.example.Student_Library_Management_System.model.Student;
import com.demo.example.Student_Library_Management_System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String S(@RequestBody  StudentRequestDto studentRequestDto){
       String response=studentService.addStudent(studentRequestDto);
       return response;
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudent(){
      List<Student> studentList =studentService.getAllStudent();
      return studentList;
    }

    @GetMapping("/findById/{studentid}")
    public Student getStudentById(@PathVariable("studentid") int studentId){
      Student  student =studentService.getStudentById(studentId);
      return student;
    }


    @DeleteMapping("/delete/{studentid}")
    public String deleteStudentById(@PathVariable("studentid") int studentId){
       String response= studentService.deleteStudentById(studentId);
       return response;
    }

    @PutMapping("/update/{studentid}")
    public String updateStudent(@RequestBody StudentRequestDto studentRequestDto,@PathVariable("studentid") int studentId){
        String response=studentService.updateStudent(studentRequestDto,studentId);
        return response;
    }


    @GetMapping("/countStudent")
    public String countStudent(){
       String response= studentService.countStudent();
       return response;
    }
}
