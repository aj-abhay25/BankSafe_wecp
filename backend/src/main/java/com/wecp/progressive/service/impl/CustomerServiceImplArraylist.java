package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wecp.progressive.entity.Customers;
import com.wecp.progressive.service.CustomerService;

public class CustomerServiceImplArraylist implements CustomerService{

    private static List<Customers> customersList= new ArrayList<>();
   
    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        return customersList;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        customersList.add(customers);
        return customersList.size();
    }

    @Override
    public List<Customers> getAllCustomersSortedByName() throws SQLException {
        List<Customers> sortedCustomers= customersList;
        Collections.sort(sortedCustomers);
        return sortedCustomers;
    }

    public void emptyArrayList(){
        customersList=new ArrayList<>();
    }


}