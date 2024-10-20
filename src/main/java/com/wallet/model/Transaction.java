package com.wallet.model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
public class Transaction {
    /*
    * To simplify the problem, we transfer the transaction
    *  from one person with a unique national number to another person
    *  with another unique national number.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TxNumber",nullable = false,unique = true)
    Long Tx_number;
    @Column(name = "SenderNationalCode", length = 50,nullable = false)
    String Sender_National_Code;
    @Column(name = "ReciverNationalCode",nullable = false)
    String Receiver_National_Code;
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

    public String getSender_National_Code() {
        return Sender_National_Code;
    }

    public void setSender_National_Code(String sender_National_Code) {
        Sender_National_Code = sender_National_Code;
    }

    public String getReceiver_National_Code() {
        return Receiver_National_Code;
    }

    public void setReceiver_National_Code(String receiver_National_Code) {
        Receiver_National_Code = receiver_National_Code;
    }

    public Time getTX_TimeStamp() {
        return TX_TimeStamp;
    }

    public void setTX_TimeStamp(Time TX_TimeStamp) {
        this.TX_TimeStamp = TX_TimeStamp;
    }







}
