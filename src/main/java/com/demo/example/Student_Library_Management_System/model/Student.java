package com.demo.example.Student_Library_Management_System.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="student")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="age",nullable = false)
    private int age;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="mobile",nullable = false,unique = true)
    private String mobile;

    @JsonManagedReference
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;
}
