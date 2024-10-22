package com.wallet.controller;

import com.wallet.model.Account;
import com.wallet.model.Wallet;
import com.wallet.service.WalletServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/wallet")
@RestController
public class WalletController {
    @Autowired
    WalletServices walletServices;

    @PostMapping("/createwallet")
    @ResponseBody
    public Wallet createwallet(@RequestBody Wallet input) {
        return walletServices.createWallet(input);
    }
    @PostMapping("/deletewallet")
    @ResponseBody
    public String deletewallet(@RequestParam String walletAddress) {
        return walletServices.deleteWallet(walletAddress);
    }
    @GetMapping("/getwallet")
    @ResponseBody
    public Wallet getawallet(@RequestParam String walletAddress){
        return walletServices.getWalletByWalletAddress(walletAddress);
    }
}
