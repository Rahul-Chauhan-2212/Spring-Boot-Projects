package com.spring.rest.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Exception_Handler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exc)
	{
		CustomerErrorResponse error = new CustomerErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Either Customer not found or bad request");
		error.setTimeStamp(new Date()); 
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
