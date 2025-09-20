package com.wecp.progressive.dao;

import com.wecp.progressive.entity.Transactions;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDAO {
    int addTransaction(Transactions transaction);
    Transactions getTransactionById(int transactionId);
    void updateTransaction(Transactions transaction);
    void deleteTransaction(int transactionId) ;
    List<Transactions> getAllTransactions();
}
