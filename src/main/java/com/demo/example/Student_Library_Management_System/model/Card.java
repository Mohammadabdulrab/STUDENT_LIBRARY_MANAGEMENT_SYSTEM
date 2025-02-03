package com.demo.example.Student_Library_Management_System.model;


import com.demo.example.Student_Library_Management_System.enums.CardStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name="card")
public class Card {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="card_Status")
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name="create_Date")
    @CreationTimestamp // it adds auto time when card is created
    private String createDate;

    @Column(name="update_Date")
    @UpdateTimestamp // it adds the time when card is updated
    private String updateDate;


    @OneToOne
    @JoinColumn
    private Student student;

}
