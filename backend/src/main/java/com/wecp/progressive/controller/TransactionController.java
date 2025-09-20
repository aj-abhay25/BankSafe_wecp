package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Transactions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TransactionController {

    public ResponseEntity<List<Transactions>> getAllTransactions() {
        return null;
    }
    public ResponseEntity<Transactions> getTransactionById(int transactionId) {
        return null;
    }
    public ResponseEntity<Integer> addTransaction(Transactions transaction) {
        return null;
    }
    public ResponseEntity<Void> updateTransaction(int transactionId, Transactions transaction) {
        return null;
    }
    public ResponseEntity<Void> deleteTransaction(int transactionId) {
        return null;
    }
}
