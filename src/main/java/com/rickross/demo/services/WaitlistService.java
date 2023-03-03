package com.rickross.demo.services;

import com.rickross.demo.entity.Account;
import com.rickross.demo.entity.WaitlistUser;

public interface WaitlistService {
    WaitlistUser addToWaitlist(String email,
                               String firstName,
                               String lastName,
                               String leadSource);

    WaitlistUser inviteToRegister(String email);

    Account register(String inviteCode);
}
