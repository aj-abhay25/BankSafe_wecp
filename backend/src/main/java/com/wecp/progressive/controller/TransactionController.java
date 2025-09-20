package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.impl.AccountServiceImplJpa;
import com.wecp.progressive.service.impl.TransactionServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private final TransactionServiceImplJpa transactionServiceImplJpa;
    
    @Autowired
    private final AccountServiceImplJpa accountServiceImplJpa;

    public TransactionController(TransactionServiceImplJpa transactionServiceImplJpa,
            AccountServiceImplJpa accountServiceImplJpa) {
        this.transactionServiceImplJpa = transactionServiceImplJpa;
        this.accountServiceImplJpa = accountServiceImplJpa;
    }
    @GetMapping
    public ResponseEntity<List<Transactions>> getAllTransactions() {
        try {
            return new ResponseEntity<>(transactionServiceImplJpa.getAllTransactions(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{transactionId}")
    public ResponseEntity<Transactions> getTransactionById(@PathVariable Integer transactionId) {
        try {
            Transactions transaction = transactionServiceImplJpa.getTransactionById(transactionId);
            if (transaction != null) {
                return new ResponseEntity<>(transaction, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody Transactions transaction) {
        try{
            return new ResponseEntity<>(transactionServiceImplJpa.addTransaction(transaction), HttpStatus.CREATED);
        }
        catch(SQLException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{transactionId}")
    public ResponseEntity<Void> updateTransaction(@PathVariable Integer transactionId, @RequestBody Transactions transaction) {
        try {
            transactionServiceImplJpa.updateTransaction(transaction);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer transactionId) {
        try {
            transactionServiceImplJpa.deleteTransaction(transactionId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{customerId}")
    public List<Transactions> getAllTransactionByCustomerId(@PathVariable int customerId){
        return transactionServiceImplJpa.getTransactionsByCustomerId(customerId);
    }
}