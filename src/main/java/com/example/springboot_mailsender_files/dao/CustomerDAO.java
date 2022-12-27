package com.example.springboot_mailsender_files.dao;

import com.example.springboot_mailsender_files.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDAO extends JpaRepository<Customer,Integer> {
    @Query("select c from Customer c where c.activationToken.token=:token")
    Customer byToken(String token);
}
