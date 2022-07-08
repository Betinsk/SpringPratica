package com.spring.pro.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tb_client_id;
	@Column(name = "email")
	private String email;

	public Customer() {
	}

	public Customer(Long id, String email) {
		this.tb_client_id = id;
		this.email = email;
	}

	public Long getId() {
		return tb_client_id;
	}

	public void setId(Long id) {
		this.tb_client_id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
