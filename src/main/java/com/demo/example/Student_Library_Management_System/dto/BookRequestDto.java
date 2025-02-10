package com.demo.example.Student_Library_Management_System.dto;

import com.demo.example.Student_Library_Management_System.enums.Genre;

import lombok.Data;

@Data
public class BookRequestDto {
    private String name;
    private int pages;
    private Genre genre;
    private String publisherName;
    private boolean issuedToStudent;
    private int authorId;
    private int cardId;
}
