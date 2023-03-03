package com.rickross.demo;

import com.rickross.demo.activity.AddToWaitlistImpl;
import com.rickross.demo.activity.InviteToRegisterImpl;
import com.rickross.demo.activity.RegisterImpl;
import com.rickross.demo.services.WaitlistService;
import com.rickross.demo.shared.Common;
import com.rickross.demo.workflow.WaitlistWorkflowImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaitlstWorker implements CommandLineRunner {

    public WaitlstWorker(WaitlistService waitlistService) {
        this.waitlistService = waitlistService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WaitlstWorker.class, args);
    }

    @Autowired
    private final WaitlistService waitlistService;

    @Override
    public void run(String... args) throws Exception {
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(Common.WAITLIST_TASK_QUEUE);
        worker.registerWorkflowImplementationTypes(WaitlistWorkflowImpl.class);
        worker.registerActivitiesImplementations(new AddToWaitlistImpl(waitlistService));
        worker.registerActivitiesImplementations(new InviteToRegisterImpl(waitlistService));
        worker.registerActivitiesImplementations(new RegisterImpl(waitlistService));
        factory.start();
    }
}
