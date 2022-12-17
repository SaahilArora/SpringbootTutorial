package com.example.demo.dao;

import javax.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetailsRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "customer_address")
    private String address;

    @Column(name = "customer_mobile")
    private Long number;

//    @OneToOne(mappedBy = "customerDetails",
//            cascade = {
//                    CascadeType.REMOVE,
//                    CascadeType.DETACH,
//                    CascadeType.MERGE,
//                    CascadeType.PERSIST,
//                    CascadeType.REFRESH
//    },orphanRemoval = true)
//    private CustomerRepository repository;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

//    public CustomerRepository getRepository() {
//        return repository;
//    }
//
//    public void setRepository(CustomerRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public String toString() {
        return "CustomerDetailsRepository{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", number=" + number +
                '}';
    }
}
