package com.example.illex.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.illex.dto.transaction.TransactionDTO;
import com.example.illex.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionDTO createTransaction(@RequestParam Long userId, @Valid @RequestBody TransactionDTO dto){
        return transactionService.createTransaction(userId, dto);
    }

    @GetMapping
    public List<TransactionDTO> getTransactions(@RequestParam Long userId){
        return transactionService.getUserTransactions(userId);
    }


    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
    }
}
