package com.rickross.demo.activity;

import com.rickross.demo.entity.WaitlistUser;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface AddToWaitlist {
    @ActivityMethod
    WaitlistUser addToList(String email, String firstName, String lastName, String leadSource);
}
