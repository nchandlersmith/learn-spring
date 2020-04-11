package com.baeldung.ls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Showing two difference ways of using init and destroy hooks
// BeanA uses @PostConstruction and @PreDestroy annotations
// BeanB uses @Bean init and destroy methods
// BeanB has the advantage of having everything in a config class and not having spring stuff in the class itself
// BeanA style would likely be used if using component scan

@Configuration
public class AppConfig {
    @Bean
    public BeanA BeanA() {
        return new BeanA();
    }

    @Bean(initMethod = "initialize", destroyMethod = "destroy")
    public BeanB BeanB() {
        return new BeanB();
    }
}
