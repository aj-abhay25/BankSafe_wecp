package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wecp.progressive.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}