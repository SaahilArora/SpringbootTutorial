package com.example.demo.dao;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "customer", indexes = {
        @Index(name = "idx_customer_id", columnList = "id")
})
public class CustomerRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    @JsonIgnore
    private Long id;

    @Column(name = "customer_name")
    @JsonProperty("user_name")
    @Size(min=4, message = "Name should be at least 4 character long.")
    private String name;

    @Column(name = "customer_email")
    @JsonProperty("user_email")
    @NotBlank(message = "Email cannot be null.")
    private String email;

    @JsonIgnore
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_update")
    private Date lastLogin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_detail_id")
    @JsonIgnore
    private CustomerDetailsRepository customerDetails;

    public CustomerRepository() {
    }

    public CustomerRepository(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CustomerRepository(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public CustomerDetailsRepository getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetailsRepository customerDetails) {
        this.customerDetails = customerDetails;
    }

    @Override
    public String toString() {
        return "CustomerRepository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lastLogin=" + lastLogin +
                ", customerDetailsRepository=" + customerDetails +
                '}';
    }
}
