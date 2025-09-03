package com.wecp.progressive.service;


import com.wecp.progressive.entity.CreditCard;
import com.wecp.progressive.entity.Loan;
import com.wecp.progressive.repository.CreditCardRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository ccr;
    public List<CreditCard> getAllCreditCards() {
        return ccr.findAll();
    }

    public CreditCard getCreditCardById(Long id) {
        return ccr.findById(id).orElse(null);
    }

    public CreditCard createCreditCard(CreditCard creditCard) {
        return ccr.save(creditCard);
    }

    public void updateCreditCard(Long id,CreditCard creditCard) {
        CreditCard cc=ccr.findById(id).orElse(null);
        if(cc!=null){
            cc.setCardHolderName(creditCard.getCardHolderName());
            cc.setCardNumber(creditCard.getCardNumber());
            ccr.save(cc);
        }
    }

    public void deleteCreditCard(Long id) {
        ccr.deleteById(id);
    }
}