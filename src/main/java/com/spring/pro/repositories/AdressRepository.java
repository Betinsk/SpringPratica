package com.spring.pro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pro.entities.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Long> {
	
	
}
