package com.wecp.progressive.entity;
import java.util.Date;

public class Transactions {
    private int transactionId;
    private int accountId;
    private double amount;
    private String transactionType;
    private Date transactionDate;
    public Transactions() {
    }
    public Transactions(int transactionId, int accountId, double amount, String transactionType, Date transactionDate) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }
    public int getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    };
}