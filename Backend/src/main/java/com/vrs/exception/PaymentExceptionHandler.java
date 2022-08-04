package com.vrs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vrs.dto.PaymentErrorResponse;

@RestControllerAdvice
public class PaymentExceptionHandler {

	@ExceptionHandler(PaymentIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<PaymentErrorResponse> handlePaymentIdException(PaymentIdException ex) {
		PaymentErrorResponse error = new PaymentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // 404 Not found

	}

	@ExceptionHandler(PaymentDoneForBookingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<PaymentErrorResponse> handlePaymentDoneForBookingException(
			PaymentDoneForBookingException exception) {
		PaymentErrorResponse error = new PaymentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis()); // 400 Bad Request

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ValidatePaymentException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<PaymentErrorResponse> handleValidatePaymentException(ValidatePaymentException ex) {
		PaymentErrorResponse error = new PaymentErrorResponse();
		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY); // 409 Conflict

	}

}
