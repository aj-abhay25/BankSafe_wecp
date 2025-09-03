package com.wecp.progressive.dao;

import com.wecp.progressive.entity.Transactions;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDAO {
    int addTransaction(Transactions transaction) throws SQLException;
    Transactions getTransactionById(int transactionId) throws SQLException;
    void updateTransaction(Transactions transaction) throws SQLException;
    void deleteTransaction(int transactionId) throws SQLException;
    List<Transactions> getAllTransactions() throws SQLException;
}
