package com.wallet.service;

import com.wallet.model.Account;
import com.wallet.repository.AccountRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class AccountServices {

    @Autowired
    AccountRepo accountRepo;

    public String DepositOperation(Account account, double amount) {
           account.DepositCurrency(amount);
           return "Deposition was successful";
    }
    public String WithdrawOperation(Account account, double amount) {
        boolean result = account.WithdrawCurrency(amount);
        if (result) {
            return "Withdraw was successful";
        }
        else
            return "Withdraw was not successful";
    }
    public Account createAccount(Account account) {
        try {
            return accountRepo.save(account);
        } catch (DataIntegrityViolationException e) {
            throw new CustomExceptionHandler("Data integrity violation while saving account.", e);
        } catch (Exception e) {
            throw new CustomExceptionHandler("An error occurred while creating the account.", e);
        }
    }

    public Account getAccountByAccountNumber(String accountNumber) {
        try {
            return accountRepo.findByAccountNumber(accountNumber);

        } catch (EntityNotFoundException e) {
            throw new CustomExceptionHandler("Account with accountNumber " + accountNumber + " not found.", e);
        }
    }

    public void deleteAccount(String accountNumber ) {
        try {
            Account account = accountRepo.findByAccountNumber(accountNumber);
            accountRepo.delete(account);
        } catch (EntityNotFoundException e) {
            throw new CustomExceptionHandler("Account with accountNumber " + accountNumber + " not found for deletion.", e);
        } catch (Exception e) {
            throw new CustomExceptionHandler("An error occurred while deleting the account.", e);
        }
    }
}
