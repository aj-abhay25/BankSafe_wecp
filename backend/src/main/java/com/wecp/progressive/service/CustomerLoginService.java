package com.wecp.progressive.service;


import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.jwt.JwtUtil;
import com.wecp.progressive.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerLoginService implements UserDetailsService {

 @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public List<Customers> getAllCustomers() {
        return customerRepository.findAll();
    }

    
 public Optional<Customers> getCustomerById(Integer customerId) {
     return customerRepository.findById(customerId);
 }

 public Customers getCustomerByName(String name) {
     return customerRepository.findByName(name);
 }

 public Customers createCustomer(Customers customer) {
     customer.setRole("USER"); // Default role
     return customerRepository.save(customer);
 }


    
public Customers updateCustomer(Customers customer) {
        return customerRepository.save(customer);
    }

    
    public void deleteUser(Integer id) {
        customerRepository.deleteById(id);
    }

    public String loginUser(String email, String password) {
        Customers customer = customerRepository.findByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            return jwtUtil.generateToken(customer.getEmail());
        }
        throw new RuntimeException("Invalid credentials");
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customers customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new User(customer.getEmail(), customer.getPassword(),
                Collections.singleton(() -> customer.getRole()));
    }


    
public int registerUser(Customers customer) {
    customer.setRole("USER"); // Default role
    return customerRepository.save(customer).getCustomerId();
}


}