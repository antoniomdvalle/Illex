package com.example.illex.mapper;

import com.example.illex.model.Transaction;
import com.example.illex.dto.transaction.TransactionDTO;
import com.example.illex.model.User;


public class TransactionMapper {
    public static Transaction toEntity(TransactionDTO dto, User user){
        Transaction transaction = new Transaction();

        transaction.setType(dto.getType());
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setDate(dto.getDate());
        transaction.setUser(user);
        
        return transaction;
    }

    public static TransactionDTO toDTO(Transaction transaction){
        TransactionDTO dto = new TransactionDTO();
        dto.setType(transaction.getType());
        dto.setAmount(transaction.getAmount());
        dto.setDescription(transaction.getDescription());
        dto.setDate(transaction.getDate());
        dto.setCategory(transaction.getCategory());

        return dto;
    }
}
