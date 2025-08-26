package com.wecp.progressive.service;


import com.wecp.progressive.entity.Transactions;

import java.sql.SQLException;
import java.util.List;

public interface TransactionService {
    List<Transactions> getAllTransactions() throws SQLException;
    Transactions getTransactionById(int transactionId) throws SQLException;
    int addTransaction(Transactions transaction) throws SQLException;
    void updateTransaction(Transactions transaction) throws SQLException;
    void deleteTransaction(int transactionId) throws SQLException;
    List<Transactions> getTransactionsByCustomerId(int customerId) throws SQLException;
}