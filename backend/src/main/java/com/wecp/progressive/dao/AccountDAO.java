package com.wecp.progressive.dao;


import com.wecp.progressive.entity.Accounts;

import java.util.List;

public interface AccountDAO {
    int addAccount(Accounts accounts);
    Accounts getAccountById(int accountId);
    void updateAccount(Accounts accounts);
    void deleteAccount(int accountId);
    List<Accounts> getAllAccounts();
}