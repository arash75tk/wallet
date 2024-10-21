package com.wallet.repository;

import com.wallet.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepo extends CrudRepository<Wallet,Long> {
    Wallet findByWalletAddress(String address);
}
