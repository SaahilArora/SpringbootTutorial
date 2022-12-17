package com.example.demo.webservices;

import com.example.demo.dao.ProductRepository;
import com.example.demo.exceptionHandler.NotFoundException;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public Long saveProduct(@RequestBody ProductRepository product){
        System.out.println("Save Product");
        return service.save(product).getId();
    }

    @PutMapping("/product")
    public Long updateProduct(@RequestBody ProductRepository product){
        System.out.println("Update Product");
        if (service.getProduct(product.getId()) == null){
            throw new NotFoundException("Product not found for id: "+product.getId());
        }
        return service.save(product).getId();
    }

    @DeleteMapping("/product/{id}")
    public Long deleteProduct(@PathVariable Long id){
        System.out.println("Delete Product");
        if (service.getProduct(id) == null){
            throw new NotFoundException("Product not found for id: "+id);
        }
        service.deleteProductById(id);
        return id;
    }

    @GetMapping("/product/")
    public List<ProductRepository> getProducts(){
        System.out.println("Get Products");
        return service.getProducts();
    }
}
