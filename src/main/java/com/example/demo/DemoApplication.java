package com.example.demo;

import com.example.demo.property.Properties;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.annotation.PostConstruct;

@RefreshScope
@SpringBootApplication
public class DemoApplication {

	@Value("${database.name}")
	private String db;

	@Value("${name.test:No Value}")
	private String cloudName;

//	@Autowired
//	@Qualifier("mumbaiToBangalore")
//	Route mumbaiHighWay;

	@Autowired
	private CustomerService service;

	@Autowired
	private Properties properties;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	@PostConstruct
	public void listener(){
//		mumbaiHighWay.getRouteFrom();
//		System.out.println(db);
//
//		Customer customer = new Customer("Brian","brian@gmail.com", Instant.now(), Instant.now());
//		service.saveCustomer(customer);

//		service.getCustomers().forEach(System.out::println);

//		System.out.println(properties.getIntQA().toString());

		System.out.println(properties.getProd().getName());

		System.out.println(cloudName);
	}
}