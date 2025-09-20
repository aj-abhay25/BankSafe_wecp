package com.wecp.progressive.controller;


import com.wecp.progressive.entity.CreditCard;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CreditCardController {

    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        return null;
    }

    public ResponseEntity<CreditCard> getCreditCardById(Long id) {
        return null;
    }

    public ResponseEntity<CreditCard> createCreditCard(CreditCard creditCard) {
        return null;
    }

    public ResponseEntity<Void> updateCreditCard(Long id, CreditCard creditCard) {
        return null;
    }

    public ResponseEntity<Void> deleteCreditCard(Long id) {
        return null;
    }
}
