package com.example.illex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.illex.model.Transaction;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);
}
