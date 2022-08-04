package com.vrs.exception;

public class VehicleNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleNotFoundException() {
		super();
	}

	public VehicleNotFoundException(String message) {
		super(message);
	}

	public VehicleNotFoundException(Throwable cause) {
		super(cause);
	}

}