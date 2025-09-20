package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.exception.AccountNotFoundException;
import com.wecp.progressive.repository.AccountRepository;
import com.wecp.progressive.repository.TransactionRepository;
import com.wecp.progressive.service.AccountService;

@Service
public class AccountServiceImplJpa implements AccountService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private final AccountRepository accountRepository;
    
    public AccountServiceImplJpa(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        return accountRepository.findAll();
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        return accountRepository.save(accounts).getAccountId();
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        List<Accounts> sortedAccounts = accountRepository.findAll();
        if(sortedAccounts != null){
            sortedAccounts.sort(Comparator.comparingDouble(Accounts::getBalance));
        }
        return sortedAccounts;
    }

    @Override
    public Accounts getAccountById(int accountId) {
        Optional<Accounts> accounts = accountRepository.findById(accountId);
        if (accounts.isPresent()) {
            return accounts.get();
        }
        else {
            throw new AccountNotFoundException("No accounts found linked with this accountId");
        }
    }

    public List<Accounts> getAccountsByUser(int customerId) throws SQLException{
        return accountRepository.getAccountsByCustomerCustomerId(customerId);
    }

    public void updateAccount(Accounts accounts) throws SQLException {
        accountRepository.save(accounts);
    }

    public void deleteAccount(int accountId) throws SQLException {
        accountRepository.deleteById(accountId);
    }
    
}