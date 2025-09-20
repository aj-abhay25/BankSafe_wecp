package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Loan;
import com.wecp.progressive.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private  LoanService loanService;
    
    
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() throws SQLException {
        return new ResponseEntity<>(loanService.getAllLoans(),HttpStatus.OK);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        return new ResponseEntity<>(loanService.getLoanById(id),HttpStatus.OK);
        
    }
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        return new ResponseEntity<>(loanService.createLoan(loan),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLoan(@PathVariable Long id,@RequestBody Loan loan) {
        loanService.updateLoan(id,loan);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}