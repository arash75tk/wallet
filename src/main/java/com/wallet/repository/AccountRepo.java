package com.wallet.repository;

import com.wallet.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account, Long> {
    Account findByAccountNumber(String accountNumber);
    Account findByShebaNumber(String ShebaNumber);
}
