package com.example.illex.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.illex.dto.transaction.TransactionDTO;
import com.example.illex.mapper.TransactionMapper;
import com.example.illex.model.Transaction;
import com.example.illex.model.User;
import com.example.illex.repository.TransactionRepository;
import com.example.illex.repository.UserRepository;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    public TransactionDTO createTransaction(Long userId, TransactionDTO dto){
            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
            Transaction transaction = TransactionMapper.toEntity(dto, user);
            Transaction saved = transactionRepository.save(transaction);
            return TransactionMapper.toDTO(saved);
    }

    public List<TransactionDTO> getUserTransactions(Long userId){
        List<Transaction> transactions = transactionRepository.findByUserId(userId);
        return transactions.stream().map(TransactionMapper::toDTO).collect(Collectors.toList());
    }

    public void deleteTransaction(Long transactionId){
        if(!transactionRepository.existsById(transactionId)){
            throw new RuntimeException("Transaction not found");
        }
        transactionRepository.deleteById(transactionId);
    }

}
