package com.example.demo.health.indicators;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("PaymentDB")
public class PaymentDBHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Map<String ,String> map = new HashMap<>();
        map.put("Hello","World");
        return Health.down().withDetails(map).build();
    }
}
