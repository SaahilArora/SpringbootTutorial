package com.example.demo.services;


import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.OrderDAO;
import com.example.demo.dao.OrderRepository;
import com.example.demo.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    public Long save(OrderRepository orderRepository) {
        return orderDAO.save(orderRepository).getId();
    }

    public List<OrderRepository> getOrders(){
        return orderDAO.findAll();
    }

    public OrderRepository getOrder(Long id){
        return orderDAO.findById(id).get();
    }

    public void deleteById(Long id){
        orderDAO.deleteById(id);
    }
}