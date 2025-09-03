package com.wecp.progressive.dto;

public class CustomerAccountInfo {

    private int customerId;
    private String customerName;
    private String email;
    private int accountId;
    private double balance;
    public CustomerAccountInfo(int customerId, String customerName, String email, int accountId, double balance) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.accountId = accountId;
        this.balance = balance;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "CustomerAccountInfo [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
                + ", accountId=" + accountId + ", balance=" + balance + "]";
    }
    
}
