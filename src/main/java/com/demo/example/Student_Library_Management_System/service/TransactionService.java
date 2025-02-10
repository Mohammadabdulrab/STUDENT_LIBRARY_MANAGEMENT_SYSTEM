package com.demo.example.Student_Library_Management_System.service;

import com.demo.example.Student_Library_Management_System.converters.TransactionConverter;
import com.demo.example.Student_Library_Management_System.dto.TransactionRequestDto;
import com.demo.example.Student_Library_Management_System.model.Book;
import com.demo.example.Student_Library_Management_System.model.Card;
import com.demo.example.Student_Library_Management_System.model.Transaction;
import com.demo.example.Student_Library_Management_System.repository.BookRepository;
import com.demo.example.Student_Library_Management_System.repository.CardRepository;
import com.demo.example.Student_Library_Management_System.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BookRepository bookRepository;

    public String addTransaction(TransactionRequestDto transactionRequestDto){
       Transaction transaction= TransactionConverter.convertTransactionRequestDtoToTransaction( transactionRequestDto);

       Card card=cardRepository.findById(transactionRequestDto.getCardId()).get();
       transaction.setCard(card);

       Book book=bookRepository.findById(transactionRequestDto.getBookId()).get();
       transaction.setBook(book);

       transactionRepository.save(transaction);

       return "Transaction saved successfully";
    }
}

