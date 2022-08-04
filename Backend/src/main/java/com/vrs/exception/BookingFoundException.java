package com.vrs.exception;

public class BookingFoundException extends RuntimeException {

	/**
	 * handles the exception if booking record is already present
	 */
	private static final long serialVersionUID = 1L;

	public BookingFoundException() {
		super();

	}

	public BookingFoundException(String message) {
		super(message);

	}

	public BookingFoundException(Throwable cause) {
		super(cause);

	}

}
