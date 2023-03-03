package com.rickross.demo;

import com.rickross.demo.entity.Account;
import com.rickross.demo.shared.Common;
import com.rickross.demo.workflow.WaitlistWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class InitiateWaitlist {
    public static void main(String[] args) throws Exception {
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkflowOptions options = WorkflowOptions.newBuilder().setTaskQueue(Common.WAITLIST_TASK_QUEUE).build();
        WaitlistWorkflow workflow = client.newWorkflowStub(WaitlistWorkflow.class, options);

        Account account = workflow.runWaitlistThroughAccount("hello@example.com", "Hello", "World", "Ads");
        System.out.println("Account is " + account);
        System.exit(0);
    }
}
