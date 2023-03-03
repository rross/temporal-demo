package com.rickross.demo.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String email) {
        super("Could not find account: " + email);
    }
}
