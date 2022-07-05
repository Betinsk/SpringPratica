package com.spring.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pro.entities.Client;
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
	 
    Client client = new Client(null, "Gmdust@h");
    
	@PostMapping
    public ResponseEntity<Client>save(@RequestBody Client client) {
		 userRepository.save(client);
		 return new ResponseEntity<>(client, HttpStatus.OK);
    }
}
