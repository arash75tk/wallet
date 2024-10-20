package com.wallet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AccountId;
    private String AccountNumber;
    @Min(10000) //min balance is 10000 rial
    private double Balance;
    private String AccountCreateDate;
    private String ShebaNumber;

    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long accountId) {
        AccountId = accountId;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getAccountCreateDate() {
        return AccountCreateDate;
    }

    public void setAccountCreateDate(String accountCreateDate) {
        AccountCreateDate = accountCreateDate;
    }

    public String getShebaNumber() {
        return ShebaNumber;
    }

    public void setShebaNumber(String shebaNumber) {
        ShebaNumber = shebaNumber;
    }
}
