package com.example.springboot_mailsender_files.dao;

import com.example.springboot_mailsender_files.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer,Integer> {
}
