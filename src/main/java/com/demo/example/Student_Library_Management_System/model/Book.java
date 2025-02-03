package com.demo.example.Student_Library_Management_System.model;


import com.demo.example.Student_Library_Management_System.enums.Genre;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Book")
public class Book {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;
    private int pages;

    @Column(name="genre",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    @Column(name="publisherName")
    private String publisherName;

    @Column(name="issuedToStudent",nullable = false)
    private boolean issuedToStudent;

}
