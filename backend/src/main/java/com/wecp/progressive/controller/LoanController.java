package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LoanController {

    public ResponseEntity<List<Loan>> getAllLoans() {
        return null;
    }

    public ResponseEntity<Loan> getLoanById(Long id) {
        return null;
    }

    public ResponseEntity<Loan> createLoan(Loan loan) {
        return null;
    }

    public ResponseEntity<Void> updateLoan(Long id, Loan loan) {
        return null;
    }

    public ResponseEntity<Void> deleteLoan(Long id) {
        return null;
    }
}
