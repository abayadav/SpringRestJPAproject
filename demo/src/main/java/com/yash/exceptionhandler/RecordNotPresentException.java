package com.yash.exceptionhandler;

public class RecordNotPresentException extends RuntimeException{

	
   private String message;
	
	public RecordNotPresentException(String message) {
		super(message);
		this.message=message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
