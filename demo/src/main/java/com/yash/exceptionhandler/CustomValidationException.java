package com.yash.exceptionhandler;

import org.springframework.validation.FieldError;

public class CustomValidationException extends RuntimeException{
	
	private String message;
	
	public CustomValidationException(String message) {
		super(message);
		this.message=message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
