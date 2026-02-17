package com.example.illex.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;



@Entity
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String type; // Income or Expense
    private String category;
    private String description;

    @Column(nullable=false)
    private BigDecimal amount;

    @Column(nullable=false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;


    public Transaction (){}

    public long getId(){return id;}

    public String getType(){return type;}
    public void setType(String type){this.type = type;}

    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public BigDecimal getAmount(){return amount;}
    public void setAmount(BigDecimal amount){this.amount = amount;} 

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    public LocalDateTime getDate(){return date;}
    public void setDate(LocalDateTime date){this.date = date;}
}
