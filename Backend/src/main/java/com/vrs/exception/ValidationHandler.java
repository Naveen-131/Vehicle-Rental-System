package com.vrs.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vrs.entities.ActiveBookingErrorResponse;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ActiveBookingErrorResponse error = new ActiveBookingErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		ex.getBindingResult().getAllErrors().forEach(e -> {
			String message = e.getDefaultMessage();
			error.setMessage(message);
		});
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
