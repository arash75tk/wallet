package com.wallet.controller;

import com.wallet.model.Transaction;
import com.wallet.model.Wallet;
import com.wallet.model.transactionConvert;
import com.wallet.repository.AccountRepo;
import com.wallet.repository.WalletRepo;
import com.wallet.service.AccountServices;
import com.wallet.service.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transaction")
@RestController
public class TransactionController {
    @Autowired
    TransactionServices transactionServices;
    @Autowired
    AccountServices accountServices;
    @Autowired
    WalletRepo walletRepo;
    @Autowired
    AccountRepo accountRepo;


    @PostMapping("/depositaccount")
    @ResponseBody
    public String  tx_depositaccount(@RequestBody transactionConvert input) {
        Transaction transaction = input.convertToEntity(input,walletRepo,accountRepo);
        boolean result = transactionServices.validateTransactionVolumeLimitAccount(transaction.getAccount().getAccountNumber());
        if(!result) {return "transaction volume limit exceeded";}
        return accountServices.DepositOperation(accountRepo.findByAccountNumber(input.getAccountNumber()),transaction.getTx_amount());
    }
    @PostMapping("/withdrawaccount")
    @ResponseBody
    public String  tx_withdrawaccount(@RequestBody transactionConvert input) {
        Transaction transaction = input.convertToEntity(input,walletRepo,accountRepo);
        return accountServices.WithdrawOperation(accountRepo.findByAccountNumber(input.getAccountNumber()),transaction.getTx_amount());
    }
}
