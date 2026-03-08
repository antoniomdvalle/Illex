package com.example.illex.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.illex.model.TransactionType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransactionDTO {
    
    @NotNull
    private TransactionType type;

    @NotNull
    private String category;

    private String description;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private LocalDateTime time;

    public TransactionDTO(){}

    public TransactionType getType(){return type;}
    public void setType(TransactionType type){this.type = type;}

    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public BigDecimal getAmount(){return amount;}
    public void setAmount(BigDecimal amount){this.amount = amount;}

    public LocalDateTime getDate(){return time;}
    public void setDate(LocalDateTime time){this.time = time;}
}
