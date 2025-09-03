package com.wecp.progressive.controller;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {

    public ResponseEntity<List<Customers>> getAllCustomers() {
        return null;
    }

    public ResponseEntity<Customers> getCustomerById(int customerId) {
        return null;
    }

    public ResponseEntity<Integer> addCustomer(Customers customers) {
        return null;
    }

    public ResponseEntity<Void> updateCustomer(int customerId, Customers customers) {
        return null;
    }
    public ResponseEntity<Void> deleteCustomer(int customerId) {
        return null;
    }

    public ResponseEntity<List<Transactions>> getAllTransactionsByCustomerId(int customerId) {
        return null;
    }
}
