package com.demo.example.Student_Library_Management_System.converters;

import com.demo.example.Student_Library_Management_System.dto.CardRequestDto;
import com.demo.example.Student_Library_Management_System.model.Card;

import static com.demo.example.Student_Library_Management_System.model.Card.*;


public   class CardConverter {
    public static Card convertCardRequestDtoToCard(CardRequestDto cardRequestDto){
       Card card= Card.builder().cardStatus(cardRequestDto.getCardStatus()).build();
        return card;
    }
}
