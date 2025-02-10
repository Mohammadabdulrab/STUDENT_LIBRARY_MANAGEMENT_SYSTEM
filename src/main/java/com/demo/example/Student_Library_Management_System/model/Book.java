package com.demo.example.Student_Library_Management_System.model;


import com.demo.example.Student_Library_Management_System.enums.Genre;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="Book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="pages",nullable = false)
    private int pages;

    @Column(name="genre",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Genre genre;

    @Column(name="publisherName")
    private String publisherName;

    @Column(name="issuedToStudent",nullable = false)
    private boolean issuedToStudent;


    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Author author;


    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;


    @JsonManagedReference
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> transactionForBook=new ArrayList<>();

}
