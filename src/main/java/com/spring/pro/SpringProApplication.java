package com.spring.pro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.pro.entities.Adress;
import com.spring.pro.entities.Customer;
import com.spring.pro.repositories.AdressRepository;
import com.spring.pro.repositories.CustomerRepository;

@SpringBootApplication
public class SpringProApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProApplication.class, args);
	}
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AdressRepository adressRepository;
	

	@Override
	public void run(String... args) throws Exception {
		Customer customer1 = new Customer(null, "Gmdust@hotmail.com", "Carlos");
		Customer customer2 = new Customer(null, "Test@hotmail.com", "Flavia");
		
		Adress adress1 = new Adress(null, "E 58th st", "New York", "New York City" );
		Adress adress2 = new Adress(null, "Silliman st", "California", "San Francisco" );

		
		
		adressRepository.saveAll(Arrays.asList(adress1, adress2));
		customerRepository.saveAll(Arrays.asList(customer1, customer2));		
		
		
		
	}

}
