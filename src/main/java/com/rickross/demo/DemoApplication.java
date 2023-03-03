//package com.rickross.demo;
//
//import com.rickross.demo.entity.Account;
//import com.rickross.demo.entity.WaitlistUser;
//import com.rickross.demo.services.WaitlistService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class DemoApplication implements CommandLineRunner {
//	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
//
//	private final WaitlistService waitlistService;
//
//	public DemoApplication(WaitlistService waitlistService) {
//		this.waitlistService = waitlistService;
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("Starting the application");
//		WaitlistUser wilma = waitlistService.
//				addToWaitlist("wilma@flintsones.com",
//						"Wilma",
//						"Rubble",
//						"Tablet");
//
//		logger.info("wilma is " + wilma);
//
//		// send an invitation
//		WaitlistUser wilmaReg = waitlistService.inviteToRegister(wilma.getEmail());
//		logger.info("registered wilma is " + wilmaReg);
//
//		Account willmaAccount = waitlistService.register(wilmaReg.getInviteCode());
//		logger.info("After wilma is registered her account is " + willmaAccount);
//
//
//		logger.info("Finished the application");
//	}
//}
