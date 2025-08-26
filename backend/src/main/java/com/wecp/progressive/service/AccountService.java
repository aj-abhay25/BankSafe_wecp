package com.wecp.progressive.service;


import com.wecp.progressive.entity.Accounts;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {

    List<Accounts> getAllAccounts() throws SQLException;

    int addAccount(Accounts accounts) throws SQLException;

    List<Accounts> getAllAccountsSortedByBalance() throws SQLException;

    default public void emptyArrayList() {
    }

    //Do not implement these methods in AccountServiceImplArraylist.java class
    default List<Accounts> getAccountsByUser(int userId) throws SQLException {
        return List.of();
    }
    default Accounts getAccountById(int accountId) throws SQLException {
        return null;
    }
    default void updateAccount(Accounts accounts) throws SQLException {}
    default void deleteAccount(int accountId) throws SQLException {}
}