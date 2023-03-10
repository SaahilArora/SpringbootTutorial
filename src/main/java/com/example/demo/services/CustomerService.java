package com.example.demo.services;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.dao.CustomerDetailDAO;
import com.example.demo.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerDetailDAO detailDAO;

    private static List<CustomerRepository> list;

    public Long save(CustomerRepository customer) {
        customer.setLastLogin(new Date());
        Long customerId = customerDAO.save(customer).getId();
        System.out.println("New Customer is saved: "+ customerId);
        return customerId;
    }

    public void delete(Long id){
        try {
            customerDAO.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<CustomerRepository> getCustomers(){
        System.out.println("Get All Customers");
        return customerDAO.findAll();
    }

    public CustomerRepository getCustomer(Long id){
        return customerDAO.findById(id).orElse(null);
    }

    public CustomerRepository getCustomerByIdOrName(Long id, String name){
        Optional<CustomerRepository> customerRepository = customerDAO.findByIdOrName(id,name);
        return customerRepository.orElse(null);
    }

    public void deleteCustomerDetails(Long id){
//        detailDAO.deleteById(id);
    }

    public List<CustomerRepository> loadCustomers(){
        return list;
    }


    static {
        list = new ArrayList<>();
        list.add(new CustomerRepository("Holmes","Holmes@gmail.com"));
        list.add(new CustomerRepository("Micheal","Micheal@gmail.com"));
        list.add(new CustomerRepository("Albert","Albert@gmail.com"));
        list.add(new CustomerRepository("Ravindran","Ravindran@gmail.com"));
        list.add(new CustomerRepository("Cook","Cook@gmail.com"));
        list.add(new CustomerRepository("Stuart","Stuart@gmail.com"));
    }
}