package com.vrs.exception;

public class BookingVehicleNotFoundException extends RuntimeException {

	/**
	 * handles the exception if vehicle record is not present for a given booking id
	 */
	private static final long serialVersionUID = 1L;

	public BookingVehicleNotFoundException() {
		super();

	}

	public BookingVehicleNotFoundException(String message) {
		super(message);

	}

	public BookingVehicleNotFoundException(Throwable cause) {
		super(cause);

	}

}
