package com.demo.example.Student_Library_Management_System.converters;

import com.demo.example.Student_Library_Management_System.dto.BookRequestDto;
import com.demo.example.Student_Library_Management_System.model.Book;

public  class BookConverter {
    public static Book convertBookRequestDtoToBook(BookRequestDto bookRequestDto){
        Book book= Book.builder().name(bookRequestDto.getName())
                .genre(bookRequestDto.getGenre())
                .pages(bookRequestDto.getPages())
                .issuedToStudent(bookRequestDto.isIssuedToStudent())
                .publisherName(bookRequestDto.getPublisherName()).build();
        return book;
    }
}
