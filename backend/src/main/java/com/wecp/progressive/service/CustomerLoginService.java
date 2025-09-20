package com.wecp.progressive.service;


import com.wecp.progressive.entity.Customers;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public class CustomerLoginService implements UserDetailsService {

    public List<Customers> getAllCustomers() {
        return null;
    }

    public Optional<Customers> getCustomerById(Integer customer) {
        return null;
    }
    public Customers getCustomerByName(String name)
    {
        return null;
    }
    public Customers createCustomer(Customers customer) {
        return null;
    }

    public Customers updateCustomer(Customers customer) {
        return null;
    }

    public void deleteUser(Integer id) {

    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}