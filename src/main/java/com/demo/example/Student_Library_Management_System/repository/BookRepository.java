package com.demo.example.Student_Library_Management_System.repository;


import com.demo.example.Student_Library_Management_System.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
