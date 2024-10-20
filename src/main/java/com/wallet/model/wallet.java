package com.wallet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Pattern(regexp = "^.{10}$")
    @Column(unique=true,nullable=false)
    private String WalletAddress;
    @Column(nullable=false)
    double Balance;


}
