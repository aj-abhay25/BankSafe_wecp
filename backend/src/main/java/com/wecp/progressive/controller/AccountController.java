package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



public class AccountController {


    public ResponseEntity<List<Accounts>> getAllAccounts() {
        return null;
    }

    public ResponseEntity<Accounts> getAccountById(int accountId) {
        return null;
    }

    public ResponseEntity<List<Accounts>> getAccountsByUser(String param) {
        return null;
    }

    public ResponseEntity<Integer> addAccount(Accounts accounts) {
        return null;
    }

    public ResponseEntity<Void> updateAccount(int accountId, Accounts accounts) {
        return null;
    }

    public ResponseEntity<Void> deleteAccount(int accountId) {
        return null;
    }
}