package com.demo.example.Student_Library_Management_System.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Author")
public class Author {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private double rating;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksByAuthor=new ArrayList <>();
}
