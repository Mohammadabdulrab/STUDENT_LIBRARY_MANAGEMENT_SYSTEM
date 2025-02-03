package com.demo.example.Student_Library_Management_System.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="age",nullable = true)
    private int age;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="mobile",nullable = false,unique = true)
    private String mobile;
}
