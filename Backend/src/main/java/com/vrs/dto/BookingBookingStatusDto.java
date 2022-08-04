package com.vrs.dto;

import com.vrs.entities.Booking;

public class BookingBookingStatusDto {
	private Booking booking;
	private String status;

	public BookingBookingStatusDto() {
		super();

	}

	public BookingBookingStatusDto(Booking booking, String status) {
		super();
		this.booking = booking;
		this.status = status;
	}

	public int getBooking() {
		return booking.getBookingId();
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingBookingStatusDto [booking=" + booking + ", status=" + status + "]";
	}

}
