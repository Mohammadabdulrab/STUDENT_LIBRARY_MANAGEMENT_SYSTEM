package com.demo.example.Student_Library_Management_System.converters;

import com.demo.example.Student_Library_Management_System.dto.StudentRequestDto;
import com.demo.example.Student_Library_Management_System.model.Student;

public class StudentConverter {
    // convert the StudentRequestDto into the Student model class

      public static Student convertStudentRequestDtoToStudent(StudentRequestDto studentRequestDto){
          Student student=Student.builder().name(studentRequestDto.getName())
                  .age(studentRequestDto.getAge()).email(studentRequestDto.getEmail())
                  .address(studentRequestDto.getAddress()).mobile(studentRequestDto.getMobile()).build();

          return student;
    }
}
