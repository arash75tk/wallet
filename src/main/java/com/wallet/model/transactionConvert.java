package com.wallet.model;

import com.wallet.repository.AccountRepo;
import com.wallet.repository.WalletRepo;

import java.sql.Timestamp;

public class transactionConvert {
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public Timestamp getTxTimeStamp() {
        return txTimeStamp;
    }

    public void setTxTimeStamp(Timestamp txTimeStamp) {
        this.txTimeStamp = txTimeStamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getTxAmount() {
        return txAmount;
    }

    public void setTxAmount(Long txAmount) {
        this.txAmount = txAmount;
    }

    public String getTxNumber() {
        return txNumber;
    }

    public void setTxNumber(String txNumber) {
        this.txNumber = txNumber;
    }

    private String txNumber;
    private Long txAmount;
    private String action; // Use String for the enum name
    private Timestamp txTimeStamp;
    private String walletAddress;
    private String accountNumber;

    public Transaction convertToEntity(transactionConvert txconvert, WalletRepo walletRepository, AccountRepo accountRepository) {
        Transaction transaction = new Transaction();
        transaction.setTx_number(txconvert.getTxNumber());
        transaction.setAction(AccountAction.valueOf(txconvert.getAction())); // Convert String to enum
        transaction.setTX_TimeStamp(txconvert.getTxTimeStamp());
        if(txconvert.getWalletAddress()!=null) {
            Wallet wallet = walletRepository.findByWalletAddress(txconvert.getWalletAddress());
            transaction.setWallet(wallet);
        }
        if(txconvert.getAccountNumber()!=null) {
            Account account = accountRepository.findByAccountNumber(txconvert.getAccountNumber());
            transaction.setAccount(account);
        }

        return transaction;
    }
}
