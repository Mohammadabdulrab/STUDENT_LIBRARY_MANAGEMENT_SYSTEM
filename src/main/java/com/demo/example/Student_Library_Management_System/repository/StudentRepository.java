package com.demo.example.Student_Library_Management_System.repository;

import com.demo.example.Student_Library_Management_System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // customize query


    //1. writing own methods with fields or attribute with JPA support

    public Student findByEmail(String email);

    public List<Student> findByName(String Name);

    public List<Student> findByAge(int age);

    //2. writing our own complete query without JPA support

    @Query(nativeQuery = true,value = "select * student where email=inputEmail")
    public Student getStudentByEmail(String inputEmail);



}
