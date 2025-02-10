package com.demo.example.Student_Library_Management_System.converters;

import com.demo.example.Student_Library_Management_System.dto.TransactionRequestDto;
import com.demo.example.Student_Library_Management_System.model.Transaction;

public  class TransactionConverter {

    public static Transaction convertTransactionRequestDtoToTransaction(TransactionRequestDto transactionRequestDto){
       Transaction transaction= Transaction.builder().transactionStatus(transactionRequestDto.getTransactionStatus())
                .fine(transactionRequestDto.getFine())
                .issuedOperation(transactionRequestDto.isIssuedOperation()).build();

        return transaction;
    }
}
