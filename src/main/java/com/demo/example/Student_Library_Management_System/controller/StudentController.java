package com.demo.example.Student_Library_Management_System.controller;


import com.demo.example.Student_Library_Management_System.dto.StudentRequestDto;
import com.demo.example.Student_Library_Management_System.model.Student;
import com.demo.example.Student_Library_Management_System.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // ResponseEntity-> inbuilt class for sending the standard response from APIs

    // Loggers-> Display the message  in the console which helps in tracking of the application flow
/*
   different levels of loggers

   info-> to display the normal information of application
   error-> to display the errors and exceptions message
   warn-> to display the warning message
   debug-> to display the message while application running in debug mode
 */

    // declaring logger

    Logger logger= LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody  StudentRequestDto studentRequestDto){
        logger.info("saveStudent API started");
       try {
           String response = studentService.addStudent(studentRequestDto);
           logger.info("saveStudent API ended");
           return ResponseEntity.ok().body(response);
       }catch (Exception e){
           logger.error("saveStudent API caught with exception :"+e.getMessage());
           return ResponseEntity.internalServerError().body(e.getMessage());
       }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllStudent(){
      try{
          List<Student> studentList =studentService.getAllStudent();
          return ResponseEntity.ok(studentList);
      }catch (Exception e){
          return ResponseEntity.internalServerError().body(e.getMessage());
      }

    }

    @GetMapping("/findById/{studentid}")
    public ResponseEntity<?> getStudentById(@PathVariable("studentid") int studentId){
     try {
         Student student = studentService.getStudentById(studentId);
         return ResponseEntity.ok(student);
     }catch (Exception e){
         return ResponseEntity.internalServerError().body(e.getMessage());
     }
    }


    @DeleteMapping("/delete/{studentid}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("studentid") int studentId){
      try {
          String response = studentService.deleteStudentById(studentId);
          return ResponseEntity.ok(response);
      }catch (Exception e){
          return ResponseEntity.internalServerError().body(e.getMessage());
      }
    }

    @PutMapping("/update/{studentid}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentRequestDto studentRequestDto,@PathVariable("studentid") int studentId){
        try {
            String response = studentService.updateStudent(studentRequestDto, studentId);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }


    @GetMapping("/countStudent")
    public String countStudent(){
       String response= studentService.countStudent();
       return response;
    }

    @GetMapping("/findpage")
    public List<Student> getAllStudentByPage(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize,@RequestParam("sortInput") String sortInput){
       List<Student> studentList= studentService.getAllStudentsByPages(pageNo,pageSize,sortInput);
       return studentList;

    }


    @GetMapping("/findByEmail")
    public Student getStudentByEmail(@RequestParam("email") String email){
        Student student=studentService.getStudentByEmail(email);
        return student;

    }



    @GetMapping("/findByEmailQuery")
    public Student getStudentByEmailQuery(@RequestParam("email") String email){
        Student student=studentService.getStudentByEmailQuery(email);
        return student;

    }


}
