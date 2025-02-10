package com.demo.example.Student_Library_Management_System.dto;

import com.demo.example.Student_Library_Management_System.enums.TransactionStatus;
import lombok.Data;

@Data
public class TransactionRequestDto {
    private TransactionStatus transactionStatus;
    private double fine;
    private boolean issuedOperation;
    private int cardId;
    private int bookId;

}
