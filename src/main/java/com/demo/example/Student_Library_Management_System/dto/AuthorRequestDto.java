package com.demo.example.Student_Library_Management_System.dto;

import lombok.Data;

@Data

public class AuthorRequestDto {
    private String name;
    private String email;
    private String country;
    private double rating;
}
