package com.wecp.progressive.exception;

public class OutOfBalanceException extends RuntimeException {
    public OutOfBalanceException(String message) {
        super(message);
    }
}