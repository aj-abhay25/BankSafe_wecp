package com.wecp.progressive.dao;


import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Customers;

import java.util.List;

public interface CustomerDAO {
    int addCustomer(Customers customers);
    Customers getCustomerById(int customerId);
    void updateCustomer(Customers customers);
    void deleteCustomer(int customerId);
    List<Customers> getAllCustomers();
    CustomerAccountInfo getCustomerAccountInfo(int customerId);
}