package com.demo.example.Student_Library_Management_System.service;

import com.demo.example.Student_Library_Management_System.converters.AuthorConverter;
import com.demo.example.Student_Library_Management_System.dto.AuthorRequestDto;
import com.demo.example.Student_Library_Management_System.model.Author;
import com.demo.example.Student_Library_Management_System.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String addAuthor(AuthorRequestDto authorRequestDto){

        Author author =AuthorConverter.convertAuthorRequestDtoToAuthor(authorRequestDto);

        authorRepository.save(author);
        return "Author saved Successfully";
    }
}
