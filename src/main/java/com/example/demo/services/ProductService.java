package com.example.demo.services;

import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    public ProductRepository save(ProductRepository productRepository) {
        return productDAO.save(productRepository);
    }

    public List<ProductRepository> getProducts(){
        return productDAO.findAll();
    }

    public ProductRepository getProduct(Long id){
        return productDAO.findById(id).get();
    }

    public void deleteProductById(Long id) {
        productDAO.deleteById(id);
    }

}