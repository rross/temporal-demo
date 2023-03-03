package com.rickross.demo.services;

import com.rickross.demo.entity.Account;
import com.rickross.demo.entity.WaitlistUser;
import com.rickross.demo.exception.WaitlistUserNotFoundException;
import com.rickross.demo.repository.AccountRepository;
import com.rickross.demo.repository.WaitlistUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
public class WaitlistServiceImpl implements WaitlistService {


    private final AccountRepository accountRepository;
    private final WaitlistUserRepository waitlistUserRepository;

    @Autowired
    WaitlistServiceImpl(WaitlistUserRepository waitlistUserRepository, AccountRepository accountRepository) {
        this.waitlistUserRepository = waitlistUserRepository;
        this.accountRepository = accountRepository;
    }
    @Override
    public WaitlistUser addToWaitlist(String email,
                               String firstName,
                               String lastName,
                               String leadSource) {

        WaitlistUser wlUser = new WaitlistUser(email, firstName, lastName, leadSource);
        waitlistUserRepository.save(wlUser);
        // TODO -- send an email

        return wlUser;
    }

    @Override
    public WaitlistUser inviteToRegister(String email) {
        WaitlistUser wlUser = waitlistUserRepository.findById(email).orElseThrow(() -> new WaitlistUserNotFoundException(email));

        // generate a unique registration code
        String uniqueCode = UUID.randomUUID().toString();
        // update the user
        wlUser.setInviteCode(uniqueCode);
        waitlistUserRepository.save(wlUser);
        // TODO: -- send an email

        return wlUser;
    }

    @Override
    @Transactional
    public Account register(String inviteCode) {
        // TODO -- exception handling
        // Find the existing user
        List<WaitlistUser> wlUsers = waitlistUserRepository.findByInviteCode(inviteCode);
        if (wlUsers == null || wlUsers.size() == 0)
            throw new WaitlistUserNotFoundException("inviteCode: " + inviteCode);
        if (wlUsers.size() > 1)
            throw new RuntimeException("Hmmm.. shouldn't have multiple users coming back for the same invite code: " + inviteCode);

        WaitlistUser wlUser = wlUsers.get(0);

        // Create an account
        Account account = new Account(wlUser.getEmail(), wlUser.getFirstName(), wlUser.getLastName(), wlUser.getLeadSource());
        // Set the user to registered and clear the invite code
        wlUser.setRegistered(true);
        wlUser.setInviteCode("");

        // save the updated user
        waitlistUserRepository.save(wlUser);

        // add an account
        accountRepository.save(account);
        return account;
    }

}
