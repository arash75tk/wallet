package com.wallet.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.sql.Time;
import java.util.Random;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "TxNumber",nullable = false,unique = true)
    String Tx_number;
    @Min(10000)
    @Column(name = "amount", nullable = false)
    Long Tx_amount;
    @Column(nullable = false)
    AccountAction action;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Time TX_TimeStamp;


    public Long getTx_amount() {
        return Tx_amount;
    }

    @PrePersist
    public void setTx_amount() {
        Tx_amount = CreateRandom_Id_8_Digits();
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
        return Tx_number;
    }

    public void setTx_number(String tx_number) {
        Tx_number = tx_number;
    }


    public Time getTX_TimeStamp() {
        return TX_TimeStamp;
    }

    public void setTX_TimeStamp(Time TX_TimeStamp) {
        this.TX_TimeStamp = TX_TimeStamp;
    }

    private long CreateRandom_Id_8_Digits() {
        Random random = new Random();
        return 10000000L + random.nextLong(90000000L);
    }







}
