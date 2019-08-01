package com.yash.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class GlobalRestControllerExceptionHandler {

	
	@ExceptionHandler(CustomValidationException.class)
	public ResponseEntity<ErrorDetails> handlevalidationException(CustomValidationException exception){
	
		ErrorDetails detail=new ErrorDetails();
		detail.setMsg(exception.getMessage());
		detail.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		
		ResponseEntity<ErrorDetails> response=new ResponseEntity<ErrorDetails>(detail,HttpStatus.BAD_GATEWAY);
		
		return response;
		
		
	}
	

}
