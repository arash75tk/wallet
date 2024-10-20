package com.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long AccountId;
    @Pattern(regexp ="^\\d{10,18}$")
    @Column(nullable = false, unique=true)
    private String AccountNumber;
    @Min(10000) //min balance is 10000 rial
    @Column(nullable = false)
    private double Balance;
    @Column(nullable = false)
    private String AccountCreateDate;
    @Pattern(regexp = "^IR\\d{24}$")
    @Column(nullable = false, unique=true)
    private String ShebaNumber;

    @ManyToOne
    @JoinColumn(name = "nationalCode", referencedColumnName = "NationalNumber")
    private User user;

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
