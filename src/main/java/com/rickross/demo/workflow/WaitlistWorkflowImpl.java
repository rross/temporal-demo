package com.rickross.demo.workflow;

import com.rickross.demo.activity.AddToWaitlist;
import com.rickross.demo.activity.InviteToRegister;
import com.rickross.demo.activity.Register;
import com.rickross.demo.entity.Account;
import com.rickross.demo.entity.WaitlistUser;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WaitlistWorkflowImpl implements WaitlistWorkflow {

    private static final Logger logger = LoggerFactory.getLogger(WaitlistWorkflowImpl.class);

    ActivityOptions options = ActivityOptions.newBuilder().setScheduleToCloseTimeout(Duration.ofSeconds(2)).build();

    private final AddToWaitlist addToWaitlist = Workflow.newActivityStub(AddToWaitlist.class, options);
    private final InviteToRegister inviteToRegister = Workflow.newActivityStub(InviteToRegister.class, options);

    private final Register register = Workflow.newActivityStub(Register.class, options);

    @Override
    public Account runWaitlistThroughAccount(String email, String firstName, String lastName, String leadSource) {
        logger.info("Starting workflow...");
        WaitlistUser wlUser = addToWaitlist.addToList(email, firstName, lastName, leadSource);

        // in a real-world scenario, some time would go by before they were invited. Maybe a manual process or automated
        Workflow.sleep(Duration.ofSeconds(3)); // arbitrary time

        WaitlistUser invitedUser = inviteToRegister.invite(wlUser.getEmail());
        // in a real-world scenario, how we would need to wait to hear back from the user
        Workflow.sleep(Duration.ofSeconds(2)); // arbitrary time

        Account account = register.register(invitedUser.getInviteCode());
        logger.info("Workflow is complete. Account is " + account);

        return account;
    }
}
