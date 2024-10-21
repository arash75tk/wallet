package com.wallet.service;


import com.wallet.model.Wallet;
import com.wallet.repository.WalletRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class WalletServices {

    @Autowired
    WalletRepo walletrepo;

    public Wallet createWallet(Wallet mywallet) {
        try {
            return walletrepo.save(mywallet);
        } catch (DataIntegrityViolationException e) {
            throw new CustomExceptionHandler("Data integrity violation while saving wallet.", e);
        } catch (Exception e) {
            throw new CustomExceptionHandler("An error occurred while creating the wallet.", e);
        }
    }

    public Wallet getWalletByWalletAddress(String walletAddress) {
        try {
            return walletrepo.findByWalletAddress(walletAddress);

        } catch (EntityNotFoundException e) {
            throw new CustomExceptionHandler("Account with walletAdrress " + walletAddress + " not found.", e);
        }
    }

    public void deleteWallet(String addrress ) {
        try {
            Wallet mywallet = walletrepo.findByWalletAddress(addrress);
            walletrepo.delete(mywallet);
        } catch (EntityNotFoundException e) {
            throw new CustomExceptionHandler("Account with addrress " + addrress + " not found for deletion.", e);
        } catch (Exception e) {
            throw new CustomExceptionHandler("An error occurred while deleting the account.", e);
        }
    }
}
