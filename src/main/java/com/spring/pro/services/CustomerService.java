package com.spring.pro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pro.controller.CustomerResource;
import com.spring.pro.entities.Customer;
import com.spring.pro.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerResource customerResource;
	
	private CustomerRepository customerRepository;
	
	@SuppressWarnings("unchecked")
	public List<Customer> insert() {
		
		Customer customer1 = new Customer(null, "Gmdust@hotmail.com");
		Customer customer2 = new Customer(null, "Test@hotmail.com");

		List list = new ArrayList<>();
		list.add(customer1);
		list.add(customer2);
		
		customerRepository.saveAll(list);		
		
		return list;
		
	}
	
	public Customer find(Long id){
		Optional<Customer> obj = customerRepository.findById(id);
		return obj.orElse(null);
	}
	
	
}
