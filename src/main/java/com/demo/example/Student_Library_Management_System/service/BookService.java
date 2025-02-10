package com.demo.example.Student_Library_Management_System.service;

import com.demo.example.Student_Library_Management_System.converters.BookConverter;
import com.demo.example.Student_Library_Management_System.dto.BookRequestDto;
import com.demo.example.Student_Library_Management_System.model.Author;
import com.demo.example.Student_Library_Management_System.model.Book;
import com.demo.example.Student_Library_Management_System.model.Card;
import com.demo.example.Student_Library_Management_System.repository.AuthorRepository;
import com.demo.example.Student_Library_Management_System.repository.BookRepository;
import com.demo.example.Student_Library_Management_System.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){

         Book book =BookConverter.convertBookRequestDtoToBook(bookRequestDto);

         Card card= cardRepository.findById(bookRequestDto.getCardId()).get();
         book.setCard(card);

         Author author=authorRepository.findById(bookRequestDto.getAuthorId()).get();
         book.setAuthor(author);

         bookRepository.save(book);

         return "Book saved successfully";

    }

}
