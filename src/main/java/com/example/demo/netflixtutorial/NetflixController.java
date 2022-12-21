package com.example.demo.netflixtutorial;

import com.example.demo.property.Properties;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/netflix")
public class NetflixController {

    @Autowired
    private Properties properties;


    /*API To Test Netflix Feign Concept To Get Data From Third-party URI With Minimal Coding*/
    @GetMapping("/feign")
    public String feignTesting(){
        System.out.println("Feign Testing");
        return "Feign Testing";
    }

    /*API To Test Netflix CircuitBreaker Concept To Retry For 5 times If Any Service Goes Down Minimal Coding*/
    @GetMapping("/circuitBreaker")
    @Retry(name = "circuitBreaker-api", fallbackMethod = "fallBackMethod")
    public String getException(){
        System.out.println("Retry");
        throw new RuntimeException();
    }

    /*API To Test Netflix Hystrix Fault Tolerance Method onFailure To Give A Generic Response.*/
    public String fallBackMethod(Exception e){
        return "Something went wrong";
    }

    /*API To Test Netflix BulkHead Concept To Restrict API 5request/Sec. See application.properties for more information*/
    @GetMapping("/getProperties")
    @Bulkhead(name = "properties")
    public String getProperties(){
        return "Prod: "+properties.getProd().toString();
    }
}
