package com.example.demo.configurations;

import com.example.demo.impl.GFR;
import com.example.demo.impl.MUB;
import com.example.demo.impl.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfigurations {

//    @Bean
//    @Primary
//    public Route getGFRRoute(){
//        return new GFR();
//    }
//
    @Bean("mumbaiHighWay")
    public Route getMumbaiBangaloreRoute(){
        return new MUB();
    }
}
