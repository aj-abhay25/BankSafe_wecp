package com.wecp.progressive.dao;
import com.wecp.progressive.dao.CustomerDAO;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Customers;

public class CustomerDAOImpl implements CustomerDAO{
    private CustomerDAO customerDAO;
    
    public CustomerDAOImpl() {
        this.customerDAO = customerDAO;
    }

    @Override
    public int addCustomer(Customers customers) {
        int generatedID=-1;
        return -1;
    }

    @Override
    public Customers getCustomerById(int customerId) {
        return null;
    }

    @Override
    public void updateCustomer(Customers customers) {
        
    }

    @Override
    public void deleteCustomer(int customerId) {
        
    }

    @Override
    public List<Customers> getAllCustomers() {
        List<Customers> customers = new ArrayList<>();
        return customers;
    }

    @Override
    public CustomerAccountInfo getCustomerAccountInfo(int customerId) {
        return null;
    }


}
