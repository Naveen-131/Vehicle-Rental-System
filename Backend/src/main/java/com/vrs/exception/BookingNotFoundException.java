package com.vrs.exception;

public class BookingNotFoundException extends RuntimeException {

	/**
	 * handles the exception if booking record is not present
	 */
	private static final long serialVersionUID = 1L;

	public BookingNotFoundException() {
		super();

	}

	public BookingNotFoundException(String message) {
		super(message);

	}

	public BookingNotFoundException(Throwable cause) {
		super(cause);

	}

}
