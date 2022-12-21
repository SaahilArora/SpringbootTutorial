package com.example.demo.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityFilters {

    @Bean
    public SecurityFilterChain securityFilters(HttpSecurity httpSecurity) throws Exception {
        /*All Request should be authenticated*/
        httpSecurity.authorizeHttpRequests(
                auth-> auth.anyRequest().authenticated());
        /*If a request isn't authenticated. A popup should be shown for user and password.*/
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
