package com.rickross.demo.exception;

public class WaitlistUserNotFoundException extends RuntimeException {
    public WaitlistUserNotFoundException(String email) {
        super("Could not find wait list user " + email);
    }
}
