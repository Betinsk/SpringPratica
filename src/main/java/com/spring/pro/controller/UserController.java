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

import com.spring.pro.entities.Client;
import com.spring.pro.exceptions.ResourceNotFoundException;
import com.spring.pro.repositories.UserRepository;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping
	public String get() {
		return "hellow";
	}

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public List<Client> Get() {
        return userRepository.findAll();
    }
	 
    
	@PostMapping("/save")
    public ResponseEntity<Client>save(@RequestBody Client client) {
		 userRepository.save(client);
		 return new ResponseEntity<>(client, HttpStatus.OK);
     } 
	
	
	 @DeleteMapping("delete/{id}")
	    public Map <String, Boolean> deleteEmployee(@PathVariable(value = "id") Long tb_client_id)
	    throws ResourceNotFoundException {
	        Client client = userRepository.findById(tb_client_id)
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
