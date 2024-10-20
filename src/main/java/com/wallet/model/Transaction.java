package com.wallet.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TxNumber",nullable = false,unique = true)
    Long Tx_number;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Time TX_TimeStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTx_number() {
        return Tx_number;
    }

    public void setTx_number(Long tx_number) {
        Tx_number = tx_number;
    }


    public Time getTX_TimeStamp() {
        return TX_TimeStamp;
    }

    public void setTX_TimeStamp(Time TX_TimeStamp) {
        this.TX_TimeStamp = TX_TimeStamp;
    }







}
