package com.example.springboot_mailsender_files.dao;

import com.example.springboot_mailsender_files.models.ActivationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationTokenDAO extends JpaRepository<ActivationToken,Integer> {
}
