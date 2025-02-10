package com.demo.example.Student_Library_Management_System.model;


import com.demo.example.Student_Library_Management_System.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Table(name="transaction")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="transaction_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name="transaction_date",nullable = false)
    @CreationTimestamp
    private Date trasactionDate;

    @Column(name="fine",nullable = false)
    private double fine;

    @Column(name="is_issued_Operation",nullable = false)
    private boolean issuedOperation;


    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;


    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;
}
