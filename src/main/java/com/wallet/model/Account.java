package com.wallet.model;

import com.wallet.service.RandomStringGen;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Pattern(regexp ="^\\d{10,18}$")
    @Column(nullable = false, unique=true)
    private String accountNumber;
    @Min(10000) //min balance is 10000 rial
    @Column(nullable = false)
    private double balance;
    @Column(nullable = false)
    private String accountCreateDate;
    @Pattern(regexp = "^IR\\d{24}$")
    @Column(nullable = false, unique=true)
    private String shebaNumber;

    @ManyToOne
    @JoinColumn(name = "nationalCode", referencedColumnName = "nationalNumber")
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> TXs = new ArrayList<>();

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountCreateDate() {
        return accountCreateDate;
    }

    public void setAccountCreateDate(String accountCreateDate) {
        this.accountCreateDate = accountCreateDate;
    }

    public String getShebaNumber() {
        return shebaNumber;
    }

    public void setShebaNumber(String shebaNumber) {
        this.shebaNumber = shebaNumber;
    }
    public void DepositCurrency(double balance){
        this.balance += balance;
    }
    public boolean WithdrawCurrency(double balance){
        if(this.balance < balance+10000){ // this line checks that if amount of balance withdraws , the minimum balance exists
            return false;
        }
        this.balance -= balance;
        return true;
    }
    @PrePersist
    public void create_Seba_AccountNumber(){
        accountNumber = RandomStringGen.generateNumericRandomString(14);
        shebaNumber = "IR"+ RandomStringGen.generateNumericRandomString(24);
    }
}
