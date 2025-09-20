package com.wecp.progressive.dao;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.entity.Customers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    private List<Accounts> accountsList = new ArrayList<Accounts>();

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        List<Accounts> accounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM accounts";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int accountId = resultSet.getInt("account_id");
                int customerId = resultSet.getInt("customer_id");
                double balance = resultSet.getDouble("balance");
                accounts.add(new Accounts(accountId, customerId, balance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return accounts;

    }

    public List<Accounts> getAllAccountsByCustomer(int customer_id) throws SQLException {
        List<Accounts> accounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM accounts where customer_id = '"+customer_id+"'";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int accountId = resultSet.getInt("account_id");
                int customerId = resultSet.getInt("customer_id");
                double balance = resultSet.getDouble("balance");

                accounts.add(new Accounts(accountId, customerId, balance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return accounts;
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "SELECT * FROM accounts WHERE account_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, accountId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                double balance = resultSet.getDouble("balance");
                return new Accounts(accountId, customerId, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        int generatedID = -1;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "INSERT INTO accounts (customer_id, balance) VALUES (?, ?)";
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, accounts.getCustomerId());
            statement.setDouble(2, accounts.getBalance());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedID = resultSet.getInt(1);
                accounts.setAccountId(generatedID);
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
    public void updateAccount(Accounts accounts) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "UPDATE accounts SET customer_id = ?, balance = ? WHERE account_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, accounts.getCustomerId());
            statement.setDouble(2, accounts.getBalance());
            statement.setInt(3, accounts.getAccountId());
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
    public void deleteAccount(int accountId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DatabaseConnectionManager.getConnection();
            String sql = "DELETE FROM accounts WHERE account_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, accountId);
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


}