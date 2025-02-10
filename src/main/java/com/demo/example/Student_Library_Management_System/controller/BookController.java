package com.demo.example.Student_Library_Management_System.controller;


import com.demo.example.Student_Library_Management_System.dto.BookRequestDto;
import com.demo.example.Student_Library_Management_System.dto.StudentRequestDto;
import com.demo.example.Student_Library_Management_System.service.BookService;
import com.demo.example.Student_Library_Management_System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String S(@RequestBody BookRequestDto bookRequestDto){
        String response=bookService.addBook(bookRequestDto);
        return response;
    }
}
