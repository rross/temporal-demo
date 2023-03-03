package com.rickross.demo.activity;

import com.rickross.demo.entity.WaitlistUser;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface InviteToRegister {
    @ActivityMethod
    WaitlistUser invite(String email);
}
