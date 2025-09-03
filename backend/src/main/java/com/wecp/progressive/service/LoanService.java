package com.wecp.progressive.service;

import com.wecp.progressive.entity.Loan;
import com.wecp.progressive.repository.LoanRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    
    // public LoanService(LoanRepository loanRepository) {
    //     this.loanRepository = loanRepository;
    // }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void updateLoan(Long id,Loan loan) {
        Loan l=loanRepository.findById(id).orElse(null);
        if(l!=null){
            l.setAmount(loan.getAmount());
            l.setDuration(loan.getDuration());
            l.setLoanType(loan.getLoanType());
            loanRepository.save(l);
        }
        
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}