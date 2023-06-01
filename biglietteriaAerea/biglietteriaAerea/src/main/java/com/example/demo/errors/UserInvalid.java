package com.example.demo.errors;

public class UserInvalid extends RuntimeException{
	private static final long serialVersion=1L;
	
	public UserInvalid(String message) {
		
		super (message);
	}
	

}
