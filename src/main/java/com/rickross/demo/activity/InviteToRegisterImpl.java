package com.rickross.demo.activity;

import com.rickross.demo.entity.WaitlistUser;
import com.rickross.demo.services.WaitlistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InviteToRegisterImpl implements InviteToRegister {

    private static final Logger logger = LoggerFactory.getLogger(InviteToRegisterImpl.class);

    private final WaitlistService waitlistService;

    public InviteToRegisterImpl(WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }

    @Override
    public WaitlistUser invite(String email) {
        logger.info("invite activity was called");
        WaitlistUser wlUser =  waitlistService.inviteToRegister(email);
        logger.info("invited waitlistuser = " + wlUser);
        return wlUser;
    }
}
