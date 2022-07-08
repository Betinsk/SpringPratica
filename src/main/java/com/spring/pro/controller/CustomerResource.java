package com.spring.pro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pro.entities.Customer;
import com.spring.pro.exceptions.ResourceNotFoundException;
import com.spring.pro.repositories.CustomerRepository;

@RestController
@RequestMapping
public class CustomerResource {

	@Autowired
	private CustomerRepository userRepository;
	

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> Get() {
        return userRepository.findAll();
    }
	 
    // @RequestMapping(value = "salvar", method = RequestMethod.POST )

	@PostMapping("/save")
    public ResponseEntity<Customer>save(@RequestBody Customer customer) {
		 userRepository.save(customer);
		 return new ResponseEntity<>(customer, HttpStatus.OK);
     } 
	
	
	 @DeleteMapping("delete/{id}")
	    public Map <String, Boolean> deleteCliente(@PathVariable(value = "id") Long tb_client_id)
	    throws ResourceNotFoundException {
	        Customer client = userRepository.findById(tb_client_id)
	            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + tb_client_id));

	        userRepository.delete(client);
	        Map <String, Boolean> response = new HashMap<>();
	        response.put("Deleted", Boolean.TRUE);
	        return response;
	    }
	
	
	
	/* @PostMapping("/save")
	    public Client save(@Valid @RequestBody Client client) {
	        return userRepository.save(client);
	    }
	  */
	  
}
