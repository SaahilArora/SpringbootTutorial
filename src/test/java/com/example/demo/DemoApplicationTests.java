package com.example.demo;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private CustomerService service;

	@MockBean
	private CustomerDAO repository;

	@Test
	void saveCustomer(){
		CustomerRepository customerRepository = new CustomerRepository("Test","test@gmail.com");
		repository.save(customerRepository);
		verify(repository, times(1)).save(customerRepository);
	}

	@Test
	void deleteCustomer(){
		CustomerRepository customerRepository = new CustomerRepository(1L,"Test","test@gmail.com");
		repository.delete(customerRepository);
		verify(repository, times(1)).delete(customerRepository);
	}

	@Test
	void getAllCustomer() {
		when(repository.findAll()).thenReturn(Stream.of(new CustomerRepository("Anna","anna@gmail.com"),
				new CustomerRepository("Inna","inna@gmail.com")).collect(Collectors.toList()));
		assertEquals(2, service.getCustomers().size());
	}
}