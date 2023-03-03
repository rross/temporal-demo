package com.rickross.demo.activity;

import com.rickross.demo.entity.Account;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface Register {
    @ActivityMethod
    Account register(String inviteCode);
}
