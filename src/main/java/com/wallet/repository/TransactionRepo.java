package com.wallet.repository;

import com.wallet.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import java.sql.Timestamp;
import java.util.List;

public interface TransactionRepo extends CrudRepository<Transaction, Long> {
    List<Transaction> findByAccount_AccountNumber(String account_number);
    List<Transaction> findByWallet_WalletAddress(String wallet_number);
    Transaction findByTxNumber(String tx_number);

    @Query("SELECT t FROM Transaction t WHERE t.txTimeStamp BETWEEN :startTime AND :endTime AND t.account.accountNumber = :accountNumber")
    List<Transaction> findTransactionsBetweenInterval(@Param("startTime") Timestamp startTime,
                                                      @Param("endTime") Timestamp endTime,
                                                      @Param("accountNumber") String accountNumber);


    @Query("SELECT t FROM Transaction t WHERE t.txTimeStamp BETWEEN :startOfDay AND :endOfDay AND t.account.accountNumber = :accountNumber")
    List<Transaction> findTransactionsSentTodayFromAccount(@Param("startOfDay") Timestamp startOfDay,
                                                @Param("endOfDay") Timestamp endOfDay,
                                                @Param("accountNumber") String accountNumber);

    @Query("SELECT t FROM Transaction t WHERE t.txTimeStamp BETWEEN :startOfDay AND :endOfDay AND t.wallet.walletAddress = :walletAddress")
    List<Transaction> findTransactionsSentTodayFromWallet(@Param("startOfDay") Timestamp startOfDay,
                                                           @Param("endOfDay") Timestamp endOfDay,
                                                           @Param("walletAddress") String walletAddress);
}
