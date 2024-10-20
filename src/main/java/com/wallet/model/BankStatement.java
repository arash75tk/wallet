package com.wallet.model;
import jakarta.persistence.PrePersist;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class BankStatement {
    // for this i use a random 10 digit ID generator method in this class
    private Long statementId;
    private String accountNumber;
    private Date startDate;
    private Date endDate;
    private Date generationDate;
    private double CurrentBalance;
    private List<Transaction> transactions;

    public Long getStatementId() {
        return statementId;
    }

    @PrePersist
    public void setStatementId() {
        this.statementId = CreateRandom_Id_10_Digits();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public double getCurrentBalance() {
        return CurrentBalance;
    }

    public void setCurrentBalance(double CurrentBalance) {
        this.CurrentBalance = CurrentBalance;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    private long CreateRandom_Id_10_Digits() {
        Random random = new Random();
        return 1000000000L + random.nextLong(9000000000L);
    }


}
