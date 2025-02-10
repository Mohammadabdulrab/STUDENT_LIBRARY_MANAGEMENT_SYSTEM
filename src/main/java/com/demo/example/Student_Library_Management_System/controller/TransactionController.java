package com.demo.example.Student_Library_Management_System.controller;

import com.demo.example.Student_Library_Management_System.dto.StudentRequestDto;
import com.demo.example.Student_Library_Management_System.dto.TransactionRequestDto;
import com.demo.example.Student_Library_Management_System.service.StudentService;
import com.demo.example.Student_Library_Management_System.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        String response=transactionService.addTransaction(transactionRequestDto);
        return response;
    }
}
