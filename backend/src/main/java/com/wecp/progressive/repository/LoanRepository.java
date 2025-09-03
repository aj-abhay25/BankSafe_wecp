package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long>{
    
}