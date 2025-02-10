package com.demo.example.Student_Library_Management_System.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Author")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @JsonManagedReference
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> booksByAuthor=new ArrayList <>();
}
