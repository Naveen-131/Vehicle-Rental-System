package com.vrs.controller;

import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrs.dto.ActiveBookingDto1;
import com.vrs.dto.ActiveBookingDto2;
import com.vrs.entities.ActiveBooking;
import com.vrs.service.IActiveBookingService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class ActiveBookingController {

	private static final Logger logger = LogManager.getLogger(ActiveBookingController.class);

	@Autowired
	IActiveBookingService activeBookingService;

	// getting all activeBooking-Get
	@GetMapping("/activebooking/all")
	public ResponseEntity<List<ActiveBooking>> viewAllActiveBooking() {
		logger.info("All the Active Booking have Successfully Viewed ");
		return new ResponseEntity<>(activeBookingService.viewAllActiveBooking(), HttpStatus.OK);
	}

	// Add activeBooking-Post
	@PostMapping("/activebooking")
	public ResponseEntity<ActiveBooking> addActiveBooking( @RequestBody ActiveBooking activeBooking) {
		logger.info("New Active Booking added Successfully ");
		return new ResponseEntity<>(activeBookingService.addActiveBooking(activeBooking), HttpStatus.OK);
	}

	// Get ActiveBooking by id-Get
	@GetMapping("/activebooking/byId/{id}")
	public ResponseEntity<ActiveBooking> getActiveBookingById(@PathVariable("id") int activeBookingId) {
		logger.info("ActiveBooking had been viewed based on Id");
		return new ResponseEntity<>(activeBookingService.getActiveBookingById(activeBookingId), HttpStatus.OK);
	}

	// Delete active booking by id-Delete
	@DeleteMapping("/activebooking/byId/{id}")
	public ResponseEntity<ActiveBooking> deleteActiveBookingById(@PathVariable("id") int activeBookingId) {
		logger.info("Active Booking Deleted Successfully");
		return new ResponseEntity<>(activeBookingService.deleteActiveBookingbyId(activeBookingId), HttpStatus.OK);
	}

	// Get ActiveBooking by Status-Get
	@GetMapping("/activebooking/byStatus/{status}")
	public ResponseEntity<List<ActiveBooking>> findByStatus(@PathVariable("status") String status) {
		logger.info("Successfully viewed the Status ");
		return new ResponseEntity<>(activeBookingService.findByStatus(status), HttpStatus.OK);
	}

	// update active booking-Put
	@PutMapping("/activebooking/update")
	public ResponseEntity<ActiveBooking> updateActiveBooking(@RequestBody ActiveBooking activeBooking) {
		logger.info(" Active Booking Updated Successfully");
		return new ResponseEntity<>(activeBookingService.updateActiveBooking(activeBooking), HttpStatus.OK);
	}

	// to find by pending status
	@GetMapping("/activebooking/pending")
	public ResponseEntity<List<ActiveBooking>> findByPending() {
		logger.info("Pending List successfully viewed ");
		return new ResponseEntity<>(activeBookingService.findByPending(), HttpStatus.OK);
	}

	// to find by inprogress status
	@GetMapping("/activebooking/inprogress")
	public ResponseEntity<List<ActiveBooking>> findByInprogress() {
		logger.info("Inprogress list successfully Viewed ");
		return new ResponseEntity<>(activeBookingService.findByInprogress(), HttpStatus.OK);
	}

	// to find by cancelled status
	@GetMapping("/activebooking/cancelled")
	public ResponseEntity<List<ActiveBooking>> findByCancelled() {
		logger.info("Cancelled list successfully Viewed ");

		return new ResponseEntity<>(activeBookingService.findByCancelled(), HttpStatus.OK);
	}

	// to find by completed status
	@GetMapping("/activebooking/completed")
	public ResponseEntity<List<ActiveBooking>> findByCompleted() {
		logger.info("Completed list successfully Viewed ");

		return new ResponseEntity<>(activeBookingService.findByCompleted(), HttpStatus.OK);
	}

	// To get bookingDescription by activeBookingId
	@GetMapping("/activebooking/bookingdescription/{id}")
	public ResponseEntity<ActiveBookingDto1> getBookingDescriptionByActiveBookingId(
			@PathVariable("id") int activeBookingId) {
		return new ResponseEntity<>(activeBookingService.getBookingDescriptionByActiveBookingId(activeBookingId),
				HttpStatus.OK);
	}

	// To get totalCost by activeBookingId
	@GetMapping("/activebooking/bookingtotalcost/{id}")
	public ResponseEntity<ActiveBookingDto2> getTotalCostByActiveBookingId(@PathVariable("id") int activeBookingId) {
		return new ResponseEntity<>(activeBookingService.getTotalCostByActiveBookingId(activeBookingId), HttpStatus.OK);
	}

}
