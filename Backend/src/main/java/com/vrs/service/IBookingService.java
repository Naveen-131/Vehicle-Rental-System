package com.vrs.service;

import java.time.LocalDate;
import java.util.List;

import com.vrs.dto.BookingBookingStatusDto;
import com.vrs.dto.BookingInputDto;
import com.vrs.dto.CustomerBookingDto;
import com.vrs.entities.Booking;
import com.vrs.entities.Driver;
import com.vrs.entities.Vehicle;

public interface IBookingService {

	// add booking record
	public Booking addBooking(BookingInputDto bookingDto);
	// public Booking addBooking(Booking booking);

	// cancel booking record
	public Booking cancelBooking(int bookingId);

	// update a given boooking record
	public Booking updateBooking(Booking b);

	// view a given booking record
	public Booking viewBooking(int bookingId);

	// display all booking records
	public List<Booking> viewAllBooking();

	// display booking records based on a given date
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate);

	// display customer details with a given booking id
	public CustomerBookingDto viewCustomerDetailsByBookingId(int bookingId);
	// public Customer viewCustomerDetailsByBookingId(int bookingId);

	// display vehicle details with a given booking id
	// public BookingVehicleDto viewVehicleDetailsByBookingId(int bookingId);
	public Vehicle viewVehicleDetailsByBookingId(int bookingId);

	// display driver details with a given booking id
	public Driver viewDriverDetailsByBookingId(int bookingId);

	// display booking status by booking id
	public BookingBookingStatusDto viewBookingStatusByBookingId(int bookingId);

}
