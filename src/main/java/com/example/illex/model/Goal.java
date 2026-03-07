package com.example.illex.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="goals")
public class Goal {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;

    private BigDecimal targetAmount;

    private LocalDate deadline;


    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private GoalStatus status;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private LocalDateTime createdAt;
    
    public Goal(){}

    public Long getId(){return id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;} 

    public BigDecimal getTargetAmount(){return targetAmount;}
    public void setTargetAmount(BigDecimal targetAmount){this.targetAmount = targetAmount;}

    public LocalDate getDeadline(){return deadline;}    
    public void setDeadline(LocalDate deadline){this.deadline = deadline;}

    public GoalStatus getStatus(){return status;}
    public void setStatus(GoalStatus status){this.status = status;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}
}
