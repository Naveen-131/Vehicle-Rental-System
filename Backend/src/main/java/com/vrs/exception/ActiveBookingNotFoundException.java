package com.vrs.exception;

public class ActiveBookingNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActiveBookingNotFoundException() {
		super();
	}

	public ActiveBookingNotFoundException(String message) {
		super(message);
	}

	public ActiveBookingNotFoundException(Throwable cause) {
		super(cause);
	}

}
