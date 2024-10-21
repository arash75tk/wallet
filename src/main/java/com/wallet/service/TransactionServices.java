package com.wallet.service;

import com.wallet.model.Account;
import com.wallet.model.Transaction;
import com.wallet.repository.TransactionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServices {
    @Autowired
    TransactionRepo transactionRepo;

    public Transaction createTransaction(Transaction tx) {
        try {
            return transactionRepo.save(tx);
        } catch (DataIntegrityViolationException e) {
            throw new CustomExceptionHandler("Data integrity violation while saving tranaction.", e);
        } catch (Exception e) {
            throw new CustomExceptionHandler("An error occurred while creating the tranaction.", e);
        }
    }

    public List<Transaction> getTransactionByAccountNumber(String accountNumber) {
        try {
            return transactionRepo.findByAccount_AccountNumber(accountNumber);

        } catch (EntityNotFoundException e) {
            throw new CustomExceptionHandler("transactions with accountNumber " + accountNumber + " not found.", e);
        }
    }

    public List<Transaction> getTransactionByWalletAddress(String walletAddress) {
        try {
            return transactionRepo.findByWallet_WalletAddress(walletAddress);

        } catch (EntityNotFoundException e) {
            throw new CustomExceptionHandler("transactions with walletAddress " + walletAddress + " not found.", e);
        }
    }
    public Transaction getTransactionByTxNumber(String TxNumber) {
        try {
            return transactionRepo.findByTxNumber(TxNumber);

        } catch (EntityNotFoundException e) {
            throw new CustomExceptionHandler("transaction with TxNumber " + TxNumber + " not found.", e);
        }
    }

    public boolean validateTransactionVolumeLimitAccount(String accountNumber) {
        // Get the start of the current day
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59, 999999999);

        // Convert to Timestamp
        Timestamp startTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endTimestamp = Timestamp.valueOf(endOfDay);

        // Query the repository for a specific account
        List<Transaction> txs = transactionRepo.findTransactionsSentTodayFromAccount(startTimestamp, endTimestamp, accountNumber);
        double totaltxamount = 0;
        for (Transaction tx : txs) {
            totaltxamount += tx.getTx_amount();
        }
        if (totaltxamount >= 10000000) { //check tx volume limit 10 million Rial
            return false;
        }
        return true;
    }
    public boolean validateTransactionVolumeLimitWallet(String walletAddress) {
        // Get the start of the current day
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(23, 59, 59, 999999999);

        // Convert to Timestamp
        Timestamp startTimestamp = Timestamp.valueOf(startOfDay);
        Timestamp endTimestamp = Timestamp.valueOf(endOfDay);

        // Query the repository for a specific account
        List<Transaction> txs = transactionRepo.findTransactionsSentTodayFromWallet(startTimestamp, endTimestamp, walletAddress);
        double totaltxamount = 0;
        for (Transaction tx : txs) {
            totaltxamount += tx.getTx_amount();
        }
        if (totaltxamount >= 10000000) { //check tx volume limit 10 million Rial
            return false;
        }
        return true;
    }

}
