package com.vrs.exception;

public class ActiveBookingDuplicateValueException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActiveBookingDuplicateValueException() {
		super();
	}

	public ActiveBookingDuplicateValueException(String message) {
		super(message);
	}

	public ActiveBookingDuplicateValueException(Throwable cause) {
		super(cause);
	}

}
