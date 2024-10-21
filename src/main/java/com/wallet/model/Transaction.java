package com.wallet.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TxNumber",nullable = false,unique = true)
    private String txNumber;
    @Min(10000)
    @Column(name = "amount", nullable = false)
    private Long txAmount;
    @Column(nullable = false)
    private AccountAction action;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp txTimeStamp;


    @ManyToOne
    @JoinColumn(name = "walletAddress", referencedColumnName = "walletAddress", nullable = true)
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber", nullable = true)
    private Account account;



    public Long getTx_amount() {
        return txAmount;
    }

    @PrePersist
    public void setTx_amount() {
        txAmount = CreateRandom_Id_8_Digits();
    }

    public AccountAction getAction() {
        return action;
    }

    public void setAction(AccountAction action) {
        this.action = action;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTx_number() {
        return txNumber;
    }

    public void setTx_number(String tx_number) {
        txNumber = tx_number;
    }


    public Timestamp getTX_TimeStamp() {
        return txTimeStamp;
    }

    public void setTX_TimeStamp(Timestamp TX_TimeStamp) {
        this.txTimeStamp = TX_TimeStamp;
    }

    private long CreateRandom_Id_8_Digits() {
        Random random = new Random();
        return 10000000L + random.nextLong(90000000L);
    }







}
