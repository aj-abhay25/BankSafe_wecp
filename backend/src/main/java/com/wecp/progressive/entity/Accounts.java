package com.wecp.progressive.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Accounts implements Comparable<Accounts>{
   
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountId;

    @Column(insertable = false, updatable = false)
    private int customerId;

    private double balance;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customerId")
    private Customers customer;

    public Accounts() {
    }
    
    public Accounts(int accountId, int customerId, double balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
    }

    public Accounts(int accountId, int customerId, double balance, Customers customer) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.balance = balance;
        this.customer = customer;
    }

    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public int compareTo(Accounts o) {
       return Double.compare(this.getBalance(),o.getBalance());
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
    
}