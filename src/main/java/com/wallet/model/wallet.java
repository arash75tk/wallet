package com.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Wallet{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Pattern(regexp = "^.{10}$")
    @Column(unique=true,nullable=false)
    private String walletAddress;
    @Column(nullable=false)
    double balance;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL)
    private List<Transaction> txs = new ArrayList<>();

    public List<Transaction> getTxs() {
        return txs;
    }

    public void setTxs(List<Transaction> txs) {
        this.txs = txs;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public @Pattern(regexp = "^.{10}$") String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(@Pattern(regexp = "^.{10}$") String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
