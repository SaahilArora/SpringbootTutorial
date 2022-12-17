package com.example.demo.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component("gurgaonToFaridabad")
public class GFR implements Route{
    @Override
    public void getRouteFrom() {
        System.out.println("Gurgaon To Faridabad");
    }
}
