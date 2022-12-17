package com.example.demo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "demo")
public class Properties {

    private DefaultProperty prod;
    private DefaultProperty intQA;

    public DefaultProperty getProd() {
        return prod;
    }

    public void setProd(DefaultProperty prod) {
        this.prod = prod;
    }

    public DefaultProperty getIntQA() {
        return intQA;
    }

    public void setIntQA(DefaultProperty intQA) {
        this.intQA = intQA;
    }
}
