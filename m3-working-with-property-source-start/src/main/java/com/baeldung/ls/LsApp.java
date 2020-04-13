package com.baeldung.ls;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LsApp {

    private static final Logger LOG = LoggerFactory.getLogger(LsApp.class);

    @Value("${additional.info}")
    private String additional;

    @PostConstruct
    public void postConstruct() {
        LOG.info("Additional property {}", additional);
    }

    public static void main(final String... args) {
        SpringApplication.run(LsApp.class, args);
    }

}
