package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<Transactions> getAllTransactions() throws SQLException {
        return List.of();
    }

    @Override
    public Transactions getTransactionById(int transactionId) throws SQLException {
        return null;
    }

    @Override
    public int addTransaction(Transactions transaction) throws SQLException {
        return -1;
    }

    @Override
    public void updateTransaction(Transactions transaction) throws SQLException {
        
    }

    @Override
    public void deleteTransaction(int transactionId) throws SQLException {
        
    }

    @Override
    public List<Transactions> getTransactionsByCustomerId(int customerId) throws SQLException {
        return List.of();
    }
    
}