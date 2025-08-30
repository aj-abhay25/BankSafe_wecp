package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.dao.CustomerDAO;
import com.wecp.progressive.dao.CustomerDAOImpl;
import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDAO customerDAO;
    public CustomerServiceImpl(CustomerDAOImpl customerDAO) {
    }
    
    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return List.of();
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        return -1;
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        return List.of();
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {}

    @Override
    public void deleteCustomer(int customerId) throws SQLException {}

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        return null;
    }


}