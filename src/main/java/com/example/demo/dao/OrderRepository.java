package com.example.demo.dao;


import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "product_id")
    private int productId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderRepository{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                '}';
    }
}
