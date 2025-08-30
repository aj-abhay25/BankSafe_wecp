package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.wecp.progressive.dao.AccountDAO;
import com.wecp.progressive.dao.AccountDAOImpl;
import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountDAOImpl accountDAOImpl;
    
    public AccountServiceImpl(AccountDAOImpl accountDAOImpl) {
        this.accountDAOImpl = accountDAOImpl;
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        return List.of();
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        return -1;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        return List.of();
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        return null;
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        return null;
    }
    
    @Override
    public void updateAccount(Accounts accounts) throws SQLException {}
    
    @Override
    public void deleteAccount(int accountId) throws SQLException {}

}