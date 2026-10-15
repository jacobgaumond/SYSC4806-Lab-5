package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

// Note: Only did persistence with BuddyInfo, as that was the work specified for last lab, and
// this lab specifies to do what was done in Lab 2 but with Springboot.

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger logger = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a few BuddyInfos
            repository.save(new BuddyInfo("Homer", "1234567890"));
            repository.save(new BuddyInfo("Marge", "0987654321"));
            repository.save(new BuddyInfo("Bart", "2234567890"));
            repository.save(new BuddyInfo("Lisa", "2987654321"));
            repository.save(new BuddyInfo("Maggie", "3987654321"));

            // fetch all buddyInfos
            logger.info("BuddyInfos found with findAll():");
            logger.info("-------------------------------");
            repository.findAll().forEach(buddyInfo -> {
                logger.info(buddyInfo.toString());
            });
            logger.info("");

            // fetch an individual customer by ID
            BuddyInfo buddyInfo = repository.findById(1L).orElse(null);
            logger.info("BuddyInfo found with findById(1L):");
            logger.info("--------------------------------");
            logger.info(buddyInfo.toString());
            logger.info("");

            // fetch customers by last name
            logger.info("BuddyInfo found with findByName('Homer'):");
            logger.info("--------------------------------------------");
            repository.findByName("Homer").forEach(homer -> {
                logger.info(homer.toString());
            });
            logger.info("");
        };
    }
}


