package com.vrs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vrs.entities.CustomerErrorResponse;

@ControllerAdvice
public class CustomerExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception) {
		CustomerErrorResponse error = new CustomerErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerFoundException exception) {
		CustomerErrorResponse error = new CustomerErrorResponse();

		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY); // 409 Conflict
	}

}