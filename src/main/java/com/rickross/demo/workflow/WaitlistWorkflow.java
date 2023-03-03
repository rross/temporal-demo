package com.rickross.demo.workflow;

import com.rickross.demo.entity.Account;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface WaitlistWorkflow {
    @WorkflowMethod
    Account runWaitlistThroughAccount(String email, String firstName, String lastName, String leadSource);
}
