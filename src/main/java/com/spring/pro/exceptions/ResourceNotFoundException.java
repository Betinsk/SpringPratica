package com.spring.pro.exceptions;

public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message){
        super("Não existe esse id no banco de dados!");
    }
	
}
