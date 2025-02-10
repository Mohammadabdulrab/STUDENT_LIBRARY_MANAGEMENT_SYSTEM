package com.demo.example.Student_Library_Management_System.dto;

import com.demo.example.Student_Library_Management_System.enums.CardStatus;
import lombok.Data;

@Data
public class CardRequestDto {
    private CardStatus cardStatus;
    private int studentId;
}
