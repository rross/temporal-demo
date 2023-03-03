package com.rickross.demo.activity;

import com.rickross.demo.entity.WaitlistUser;
import com.rickross.demo.services.WaitlistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AddToWaitlistImpl implements AddToWaitlist {
    private static final Logger logger = LoggerFactory.getLogger(AddToWaitlist.class);

    private final WaitlistService waitlistService;

    public AddToWaitlistImpl(WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }

    @Override
    public WaitlistUser addToList(String email, String firstName, String lastName, String leadSource) {
        logger.info("addToList Activity has been called");
        WaitlistUser wlUser = waitlistService.addToWaitlist(email, firstName, lastName, leadSource);
        logger.info("added waitlist user=" + wlUser);
        return wlUser;
    }
}
