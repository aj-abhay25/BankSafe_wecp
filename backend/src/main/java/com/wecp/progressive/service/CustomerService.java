package com.wecp.progressive.service;


import com.wecp.progressive.entity.Customers;
import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    List<Customers> getAllCustomers() throws SQLException;
    int addCustomer(Customers customers) throws SQLException;
    List<Customers> getAllCustomersSortedByName() throws SQLException;
    default public void emptyArrayList() {}

    //Do not implement these methods in CustomerServiceImplArraylist.java class
    default void updateCustomer(Customers customers) throws SQLException {}
    default void deleteCustomer(int customerId) throws SQLException {}
    default Customers getCustomerById(int customerId) throws SQLException {
        return null;
    }

}