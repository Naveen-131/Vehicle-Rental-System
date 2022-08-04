package com.vrs.exception;

public class NegativeNumberException extends RuntimeException {

	/**
	 * handles input enter as negative integer by user
	 */
	private static final long serialVersionUID = 1L;

	public NegativeNumberException() {
		super();

	}

	public NegativeNumberException(String message) {
		super(message);
	}

	public NegativeNumberException(Throwable cause) {
		super(cause);

	}

}
