package com.example.illex.dto.dashboard;

import java.math.BigDecimal;

public class DashboardResponse {
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private BigDecimal totalBalance;

    public int activeGoals;


    public DashboardResponse(){}

    public BigDecimal getTotalIncome(){return totalIncome;}
    public void setTotalIncome(BigDecimal totalIncome){this.totalIncome = totalIncome;}

    public BigDecimal getTotalExpense(){return totalExpense;}
    public void setTotalExpense(BigDecimal totalExpense){this.totalExpense = totalExpense;}

    public BigDecimal getTotalBalance(){return totalBalance;}
    public void setTotalBalance(BigDecimal totalBalance){this.totalBalance = totalBalance;}

    public int getActiveGoals(){return activeGoals;}
    public void setActiveGoals(int activeGoals){this.activeGoals = activeGoals;}
}
