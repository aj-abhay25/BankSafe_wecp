package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.exception.CustomerAlreadyExistsException;
import com.wecp.progressive.repository.AccountRepository;
import com.wecp.progressive.repository.CustomerRepository;
import com.wecp.progressive.service.CustomerService;

@Service
public class CustomerServiceImplJpa implements CustomerService{

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerServiceImplJpa(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customerRepository.findAll();
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        Customers customers1 = customerRepository.findByNameAndEmail(customers.getName(), customers.getEmail());
        if (customers1 != null) {
            throw new CustomerAlreadyExistsException("Customer already exists");
        }
        return customerRepository.save(customers).getCustomerId();
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        List<Customers> sortedList = customerRepository.findAll();
        if(sortedList != null){
            sortedList.sort(Comparator.comparing(Customers::getName));
        }
        return sortedList;
    }

    public void updateCustomer(Customers customers) throws SQLException {
        customerRepository.save(customers);
    }

    public void deleteCustomer(int customerId) throws SQLException {
        customerRepository.deleteByCustomerId(customerId);
    }
    
    public Customers getCustomerById(int customerId) throws SQLException {
        return customerRepository.findByCustomerId(customerId);
    }
}