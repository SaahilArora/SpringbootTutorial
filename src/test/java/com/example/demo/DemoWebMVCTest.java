package com.example.demo;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.property.Properties;
import com.example.demo.services.CustomerService;
import com.example.demo.webservices.CustomerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

////@WebMvcTest(CustomerController.class)
////public class DemoWebMVCTest {
////
////    @Autowired
////    private MockMvc mockMvc;
////
////    @MockBean
////    private CustomerService service;
////
////    @MockBean
////    private Properties properties;
////
////    @Test
////    public void getAllCustomers(){
////        List<CustomerRepository> list = new ArrayList<>();
////        list.add(new CustomerRepository("A","a@gmailcom"));
////        list.add(new CustomerRepository("B","b@gmailcom"));
////
////        given(service.getCustomers()).willReturn(list);
////
////        try {
////            ResultActions response = mockMvc.perform(get("/api/customers/"));
////            response.andExpect(status().isOk())
////                    .andExpect(jsonPath("$.size()", is(list.size())));
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
////    }
//}