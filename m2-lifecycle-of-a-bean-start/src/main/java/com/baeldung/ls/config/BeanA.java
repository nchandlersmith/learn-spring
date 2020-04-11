package com.baeldung.ls.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanA {

    private static final Logger log = LoggerFactory.getLogger(BeanA.class);

    @PostConstruct
    public void post() {
        log.info("BeanA : @PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        log.info("BeanA : @PreDestroy");
    }
}
