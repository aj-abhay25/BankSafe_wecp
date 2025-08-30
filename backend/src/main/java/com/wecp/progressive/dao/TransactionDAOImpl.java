package com.wecp.progressive.dao;

import java.util.ArrayList;
import java.util.List;
import com.wecp.progressive.dao.TransactionDAO;
import com.wecp.progressive.entity.Transactions;

public class TransactionDAOImpl implements TransactionDAO{
    private TransactionDAO transactionDAO;
    
    public TransactionDAOImpl() {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public int addTransaction(Transactions transaction) {
        int generatedID=-1;
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
        List<Transactions> transactions=new ArrayList<>();
        return transactions;
    }



}
