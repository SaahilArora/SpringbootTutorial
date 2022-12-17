package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CustomerDAO extends JpaRepository<CustomerRepository, Long> {

    void deleteById(Long id);

    Optional<CustomerRepository> findByIdOrName(Long id, String name);
}
