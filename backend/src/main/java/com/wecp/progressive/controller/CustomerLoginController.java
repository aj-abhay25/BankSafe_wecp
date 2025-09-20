package com.wecp.progressive.controller;


import com.wecp.progressive.dto.LoginRequest;
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/customer")
public class CustomerLoginController {

    @Autowired
    private CustomerLoginService customerLoginService;

    @PostMapping("/register")
    public ResponseEntity<Integer> registerUser(@RequestBody Customers customer) {
        int customerId = customerLoginService.registerUser(customer);
        return ResponseEntity.ok(customerId);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Customers customer) {
        try {
            String token = customerLoginService.loginUser(customer.getEmail(), customer.getPassword());
            return ResponseEntity.ok(token);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}