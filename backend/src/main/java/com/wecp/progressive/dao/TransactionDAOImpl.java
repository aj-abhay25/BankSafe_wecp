package com.wecp.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.entity.Transactions;

public class TransactionDAOImpl implements TransactionDAO{

    @Override
    public int addTransaction(Transactions transaction) {
        return -1;
    }

    @Override
    public Transactions getTransactionById(int transactionId) {
        return null;
    }

    @Override
    public void updateTransaction(Transactions transaction) {
        
    }

    @Override
    public void deleteTransaction(int transactionId) {
        
    }

    @Override
    public List<Transactions> getAllTransactions() {
        return new ArrayList<>();
    }



}
