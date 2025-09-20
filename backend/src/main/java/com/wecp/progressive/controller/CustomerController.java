package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.impl.CustomerServiceImplArraylist;
import com.wecp.progressive.service.impl.CustomerServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerServiceImplJpa customerServiceImplJpa;

    @Autowired
    private CustomerServiceImplArraylist customerServiceImplArraylist;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {
        try {
            List<Customers> customers = customerServiceImplJpa.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable Integer customerId) {
        try {
            Customers customers = customerServiceImplJpa.getCustomerById(customerId);
            if (customers != null) {
                return new ResponseEntity<>(customers, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customers customers) {
        try {
            int customerId = customerServiceImplJpa.addCustomer(customers);
            return new ResponseEntity<>(customerId, HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer customerId, @RequestBody Customers customers) {
        try {
            customers.setCustomerId(customerId);
            customerServiceImplJpa.updateCustomer(customers);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
@PreAuthorize("hasAuthority('ADMIN')")

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer customerId) throws SQLException {
        // try{
        // customerServiceImplJpa.deleteCustomer(customerId);
        // return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        // }
        // catch(SQLException e){
        // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        // }

        try {
            boolean deleted = customerServiceImplJpa.deleteCustomer(customerId);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Customers>> getAllCustomersFromArrayList() throws SQLException {
        List<Customers> customers = customerServiceImplArraylist.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addCustomersToArrayList(@RequestBody Customers customers) throws SQLException {
        int customersList = customerServiceImplArraylist.addCustomer(customers);
        return new ResponseEntity<>(customersList, HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Customers>> getAllCustomersSortedByNameFromArrayList() throws SQLException {
        List<Customers> customerList = customerServiceImplArraylist.getAllCustomersSortedByName();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}