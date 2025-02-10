package com.demo.example.Student_Library_Management_System.repository;


import com.demo.example.Student_Library_Management_System.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
