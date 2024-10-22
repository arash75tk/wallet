package com.wallet.controller;

import com.wallet.model.Account;
import com.wallet.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/account")
@RestController
public class AccountController {
    @Autowired
    AccountServices accountServices;

    @PostMapping("/createacoount")
    @ResponseBody
    public Account createacconut(@RequestBody Account input) {
        return accountServices.createAccount(input);
    }
    @PostMapping("/deleteacoount")
    @ResponseBody
    public String deleteacconut(@RequestParam String AccountNumber) {
        return accountServices.deleteAccount(AccountNumber);
    }
    @GetMapping("/getaccount")
    @ResponseBody
    public Account getaccount(@RequestParam String AccountNumber){
        return accountServices.getAccountByAccountNumber(AccountNumber);
    }


}
