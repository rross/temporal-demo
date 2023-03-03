package com.rickross.demo;

import com.rickross.demo.entity.Account;
import com.rickross.demo.entity.WaitlistUser;
import com.rickross.demo.repository.AccountRepository;
import com.rickross.demo.repository.WaitlistUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WaitlistUserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new WaitlistUser("joe@example.com", "Joe", "Smith", "Ads")));
            log.info("Preloading " + repository.save(new WaitlistUser( "jane@example.com", "Jane", "Smith", "Ads")));
        };
    }

    @Bean
    CommandLineRunner initDatabase(AccountRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Account("fred@flintstone.com", "Fred", "Flintstone", "Tablet")));
            log.info("Preloading " + repository.save(new Account("wilma@flintsone.com", "Wilma", "Flintstone", "Fred")));
        };
    }
}
