package com.demo.example.Student_Library_Management_System.controller;


import com.demo.example.Student_Library_Management_System.dto.AuthorRequestDto;
import com.demo.example.Student_Library_Management_System.dto.StudentRequestDto;
import com.demo.example.Student_Library_Management_System.service.AuthorService;
import com.demo.example.Student_Library_Management_System.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/api")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        String response=authorService.addAuthor(authorRequestDto);
        return response;
    }
}
