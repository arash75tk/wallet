package com.wallet.service;

public class CustomExceptionHandler extends RuntimeException {
    public CustomExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}
