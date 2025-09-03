package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.AccountService;

public class AccountServiceImplArraylist implements AccountService {

    private static List<Accounts> accountsList=new ArrayList<>();
    public AccountServiceImplArraylist(){
    }
    
    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        return accountsList;
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        accountsList.add(accounts);
        return accountsList.size();
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        List<Accounts> sortedAccounts=accountsList;
        sortedAccounts.sort(Comparator.comparingDouble(Accounts :: getBalance));
        return sortedAccounts;
    }

    public void emptyArrayList(){
        accountsList=new ArrayList<>();
    }

}