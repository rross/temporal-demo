package com.rickross.demo.activity;

import com.rickross.demo.entity.Account;
import com.rickross.demo.services.WaitlistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegisterImpl implements Register {

    private static final Logger logger = LoggerFactory.getLogger(RegisterImpl.class);

    private final WaitlistService waitlistService;

    public RegisterImpl(WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }

    @Override
    public Account register(String inviteCode) {
        logger.info("register activity called");
        Account account = waitlistService.register(inviteCode);
        logger.info("account created="+account);
        return account;
    }
}
