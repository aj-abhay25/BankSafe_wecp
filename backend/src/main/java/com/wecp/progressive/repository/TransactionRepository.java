package com.wecp.progressive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
    @Query("SELECT t FROM Transactions t WHERE t.accounts.accountId = :accountId")
    List<Transactions> findByAccountId(@Param("accountId") int accountId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Transactions t WHERE t.accounts.accountId = :accountId")
    void deleteByAccountId(@Param("accountId") int accountId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Transactions t WHERE t.accounts.customer.customerId = :customerId")
    void deleteByCustomerId(@Param("customerId") int customerId);

    @Query("SELECT t FROM Transactions t WHERE t.accounts.customer.customerId = :customerId")
    List<Transactions> findByCustomerId(@Param("customerId") int customerId);

    List<Transactions> findByAccountsAccountId(int accountId);
}