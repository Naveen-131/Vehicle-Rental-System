package com.vrs.service;

import java.util.List;

import com.vrs.dto.ActiveBookingDto1;
import com.vrs.dto.ActiveBookingDto2;
import com.vrs.entities.ActiveBooking;

public interface IActiveBookingService {

	// getting all activeBooking-Get
	public List<ActiveBooking> viewAllActiveBooking();

	// Add activeBooking-Post
	public ActiveBooking addActiveBooking(ActiveBooking activeBooking);

	// Get ActiveBooking by id-Get
	public ActiveBooking getActiveBookingById(int activeBookingId);

	// Delete ActiveBooking by id-Delete
	public ActiveBooking deleteActiveBookingbyId(int activeBookingId);

	// Get ActiveBooking by Status-Get
	public List<ActiveBooking> findByStatus(String status);

	// Update ActiveBooking-Put
	public ActiveBooking updateActiveBooking(ActiveBooking activeBooking);

	// method to find pending status
	public List<ActiveBooking> findByPending();

	// method to find inprogress status
	public List<ActiveBooking> findByInprogress();

	// method to find cancelled status
	public List<ActiveBooking> findByCancelled();

	// method to find completed status
	public List<ActiveBooking> findByCompleted();

	// To get bookingDescription by activeBookingId
	public ActiveBookingDto1 getBookingDescriptionByActiveBookingId(int activeBookingId);

	// To get totalCost by activeBookingId
	public ActiveBookingDto2 getTotalCostByActiveBookingId(int activeBookingId);

}
