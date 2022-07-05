package com.spring.pro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pro.entities.Client;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {
	
	
}
