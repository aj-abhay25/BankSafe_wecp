package com.wecp.progressive.dao;
import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.dao.CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.dto.CustomerAccountInfo;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.entity.Customers;

public class CustomerDAOImpl implements CustomerDAO{
    // private CustomerDAO customerDAO;
    
    // public CustomerDAOImpl() {
    //     this.customerDAO = customerDAO;
    // }

    @Override
    public List<Customers> getAllCustomers() throws SQLException {
        List<Customers> customers = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM customers";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                customers.add(new Customers(customerId, name, email, username, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return customers;
    }

    @Override
    public Customers getCustomerById(int customerId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM customers WHERE customer_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                return new Customers(customerId, name, email,username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return  null;
    }

    @Override
    public int addCustomer(Customers customers) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int generatedID = -1;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO customers (name, email,username, password) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql,  PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, customers.getName());
            statement.setString(2, customers.getEmail());
            statement.setString(3, customers.getUsername());
            statement.setString(4, customers.getPassword());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedID = generatedKeys.getInt(1);
                customers.setCustomerId(generatedID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return generatedID;
    }

    @Override
    public void updateCustomer(Customers customers) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE customers SET name = ?, email = ?, username= ?, password =? WHERE customer_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, customers.getName());
            statement.setString(2, customers.getEmail());
            statement.setString(3, customers.getUsername());
            statement.setString(4, customers.getPassword());
            statement.setInt(5, customers.getCustomerId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void deleteCustomer(int customerId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM customers WHERE customer_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
           
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public CustomerAccountInfo getCustomerAccountInfo(int customerId) throws SQLException {
        CustomerAccountInfo customerAccountInfo = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT c.customer_id, c.name AS customer_name, c.email, a.account_id, a.balance " +
                    "FROM customers c " +
                    "INNER JOIN accounts a ON c.customer_id = a.customer_id " +
                    "WHERE c.customer_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, customerId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String customerName = resultSet.getString("customer_name");
                String email = resultSet.getString("email");
                int accountId = resultSet.getInt("account_id");
                double balance = resultSet.getDouble("balance");

                customerAccountInfo = new CustomerAccountInfo(customerId, customerName, email, accountId, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return null;
    }

}