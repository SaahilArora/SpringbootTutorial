package com.example.demo.webservices;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.exceptionHandler.NotFoundException;
import com.example.demo.exceptionHandler.PathParameterException;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/customers")
    public Long saveCustomer(@RequestBody CustomerRepository customer){
        System.out.println("Get Customer");
        return service.save(customer);
    }

    @PutMapping("/customers")
    public Long updateCustomer(@RequestBody CustomerRepository customer){
        System.out.println("Update Customer");
        if (service.getCustomer(customer.getId()) == null){
            throw new NotFoundException("Customer not found for id: "+customer.getId());
        }
        return service.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public Long deleteCustomer(@PathVariable Long id){
        System.out.println("Delete Customer");
        if (service.getCustomer(id) == null){
            throw new NotFoundException("Customer Not Found For Id: "+id);
        }
        service.delete(id);
        return id;
    }

    @DeleteMapping("/customers/details/{id}")
    public Long deleteCustomerDetails(@PathVariable Long id){
        System.out.println("Delete Customer Details");
        service.deleteCustomerDetails(id);
        return id;
    }

    @GetMapping("/customer")
    public CustomerRepository getCustomerByIdOrName(@RequestParam(name = "id", required = true) Long id,
                                                    @RequestParam(name = "name", defaultValue = "null", required = false) String name){
            if (id == null && name == null ){
                throw new PathParameterException("ID and Name parameter could not be null. Please provide either id or name to get the customer information.");
            }
            CustomerRepository customerRepository = service.getCustomerByIdOrName(id, name);
            if (customerRepository == null){
              throw new NotFoundException("Customer Not Found For Id "+id+" Or Name: "+name);
            }
            return customerRepository;
    }

    @GetMapping("/customers/")
    public List<CustomerRepository> getCustomers(){
        return service.getCustomers();
    }
}