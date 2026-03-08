package com.example.illex.dto.goal;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.illex.model.GoalStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class GoalDTO {
    
    @NotBlank
    private String name;

    @NotBlank
    @Positive
    private BigDecimal targetAmount;

    @NotNull
    private LocalDate deadline;

    private GoalStatus status;

    public GoalDTO(){}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public BigDecimal getTargetAmount(){return targetAmount;}
    public void setTargetAmount(BigDecimal targetAmount){this.targetAmount = targetAmount;}

    public LocalDate getDeadline(){return deadline;}
    public void setDeadline(LocalDate deadline){this.deadline = deadline;}

    public GoalStatus getStatus(){return status;}
    public void setStatus(GoalStatus status){this.status = status;}
}
