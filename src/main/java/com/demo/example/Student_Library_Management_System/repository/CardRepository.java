package com.demo.example.Student_Library_Management_System.repository;

import com.demo.example.Student_Library_Management_System.model.Card;
import com.demo.example.Student_Library_Management_System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}
