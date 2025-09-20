package com.wecp.progressive.service;


import com.wecp.progressive.entity.Transactions;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    List<Transactions> getAllTransactions() throws SQLException;
    Transactions getTransactionById(Integer transactionId) throws SQLException;
    int addTransaction(Transactions transaction) throws SQLException;
    void updateTransaction(Transactions transaction) throws SQLException;
    void deleteTransaction(Integer transactionId) throws SQLException;
    List<Transactions> getTransactionsByCustomerId(int customerId) throws SQLException;
}