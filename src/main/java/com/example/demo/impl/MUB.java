package com.example.demo.impl;

import org.springframework.stereotype.Component;

@Component("mumbaiToBangalore")
public class MUB implements Route{
    @Override
    public void getRouteFrom() {
        System.out.println("Mumbai to Bangalore");
    }
}
