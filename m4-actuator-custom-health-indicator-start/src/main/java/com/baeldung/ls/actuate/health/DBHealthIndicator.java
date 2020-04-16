package com.baeldung.ls.actuate.health;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DBHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (isDBUp()) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("Error Code", 503).build();
        }
    }

    private boolean isDBUp() {
        return new Random().nextBoolean();
    }

}