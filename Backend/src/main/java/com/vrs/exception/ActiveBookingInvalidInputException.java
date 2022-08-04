package com.vrs.exception;

public class ActiveBookingInvalidInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActiveBookingInvalidInputException() {
		super();
	}

	public ActiveBookingInvalidInputException(String message) {
		super(message);
	}

	public ActiveBookingInvalidInputException(Throwable cause) {
		super(cause);
	}

}
