package com.demo.example.Student_Library_Management_System.dto;


import lombok.Data;

@Data
public class StudentRequestDto {

    // hare we take input parameter which are going as request

    private String name;
    private String email;
    private int age;
    private String mobile;
    private String address;
}
