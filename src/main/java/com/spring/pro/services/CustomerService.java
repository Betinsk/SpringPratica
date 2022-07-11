package com.spring.pro.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.pro.entities.Customer;
import com.spring.pro.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	
	private CustomerRepository customerRepository;
	

	public Customer find(Long id){
		Optional<Customer> obj = customerRepository.findById(id);
		return obj.orElse(null);
	}
	
	
}
