package com.vrs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vrs.entities.BookingErrorResponse;

@ControllerAdvice
public class BookingExceptionHandler {
	// handles booking found exception
	@ExceptionHandler
	public ResponseEntity<BookingErrorResponse> handleException(BookingNotFoundException exception) {
		BookingErrorResponse error = new BookingErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found
	}

	// handles booking not found exception
	@ExceptionHandler
	public ResponseEntity<BookingErrorResponse> handleException(BookingFoundException exception) {
		BookingErrorResponse error = new BookingErrorResponse();

		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY); // 409 Conflict
	}

	// handles vehicle not found for given booking id
	@ExceptionHandler
	public ResponseEntity<BookingErrorResponse> handleException(BookingVehicleNotFoundException exception) {
		BookingErrorResponse error = new BookingErrorResponse();

		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY); // 409 Conflict
	}

	// handles negative number input data
	@ExceptionHandler
	public ResponseEntity<BookingErrorResponse> handleException(NegativeNumberException exception) {
		BookingErrorResponse error = new BookingErrorResponse();

		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY); // 409 Conflict
	}

}
