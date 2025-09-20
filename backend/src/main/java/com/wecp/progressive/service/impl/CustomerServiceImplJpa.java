package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    
public boolean deleteCustomer(Integer customerId) throws SQLException {
    Optional<Customers> customer = Optional.ofNullable(customerRepository.findById(customerId).orElse(null));
    if (customer != null) {
        customerRepository.deleteById(customerId);
        return true;
    } else {
        return false;
    }
}

    
    public Customers getCustomerById(int customerId) throws SQLException {
        return customerRepository.findByCustomerId(customerId);
    }

    
private void validateRole(Customers customer) {
    if (customer.getRole() == null ||
        (!customer.getRole().equalsIgnoreCase("USER") &&
         !customer.getRole().equalsIgnoreCase("ADMIN"))) {
        throw new IllegalArgumentException("Role must be either 'USER' or 'ADMIN'");
    }
}

}