package com.example.demo.health.indicators;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("OracleDataBase")
public class DataSourceIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().status("Service is running fine").build();
    }
}
