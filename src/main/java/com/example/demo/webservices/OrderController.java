package com.example.demo.webservices;

import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.exceptionHandler.NotFoundException;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/order")
    public Long saveProduct(@RequestBody OrderRepository order){
        System.out.println("Save Order");
        return service.save(order);
    }

    @PutMapping("/order")
    public Long updateProduct(@RequestBody OrderRepository order){
        System.out.println("Update Product");
        if (service.getOrder(order.getId()) == null){
            throw new NotFoundException("Order not found for id: "+order.getId());
        }
        return service.save(order);
    }

    @DeleteMapping("/order/{id}")
    public Long deleteProduct(@PathVariable Long id){
        System.out.println("Delete Product");
        if (service.getOrder(id) == null){
            throw new NotFoundException("Order not found for id: "+id);
        }
        service.deleteById(id);
        return id;
    }

    @GetMapping("/order/")
    public List<OrderRepository> getProducts(){
        System.out.println("Get Products");
        return service.getOrders();
    }
}
