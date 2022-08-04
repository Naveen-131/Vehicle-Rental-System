package com.vrs.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vrs.controller.UserController;
import com.vrs.entities.UserErrorResponse;

//handle exception globally
@ControllerAdvice
public class UserExceptionHandler {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exception) {
		UserErrorResponse error = new UserErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		logger.error("User not found exception");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);// 404 not found
	}

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserFoundException exception) {
		UserErrorResponse error = new UserErrorResponse();

		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		logger.error("user found exception");
		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);// 302 found
	}

}
