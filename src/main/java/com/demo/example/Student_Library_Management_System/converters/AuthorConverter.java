package com.demo.example.Student_Library_Management_System.converters;

import com.demo.example.Student_Library_Management_System.dto.AuthorRequestDto;
import com.demo.example.Student_Library_Management_System.model.Author;

public  class AuthorConverter {
     public static Author convertAuthorRequestDtoToAuthor(AuthorRequestDto authorRequestDto){
        Author author =Author.builder().name(authorRequestDto.getName()).email(authorRequestDto.getEmail())
                 .country(authorRequestDto.getCountry()).rating(authorRequestDto.getRating()).build();

        return author;
     }
}
