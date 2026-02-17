package com.example.illex.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="goals")
public class Goal {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;

    private BigDecimal targetAmount;

    private LocalDate deadline;

    private String status;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Goal(){}

    public Long getId(){return id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;} 

    public BigDecimal getTargetAmount(){return targetAmount;}
    public void setTargetAmount(BigDecimal targetAmount){this.targetAmount = targetAmount;}

    public LocalDate getDeadline(){return deadline;}    
    public void setDeadline(LocalDate deadline){this.deadline = deadline;}

    public String getStatus(){return status;}
    public void setStatus(String status){this.status = status;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}
}
