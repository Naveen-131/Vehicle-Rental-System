package com.vrs.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.vrs.dto.BookingBookingStatusDto;
import com.vrs.dto.BookingInputDto;
import com.vrs.entities.Booking;
import com.vrs.service.IBookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookingController {

	private static final Logger logger = LogManager.getLogger(BookingController.class);

	@Autowired
	IBookingService bookingServ;

	/*
	 * Method for adding booking object -POST
	 */
	@PostMapping("/booking/add")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody BookingInputDto bookingDto) {
		return new ResponseEntity<>(bookingServ.addBooking(bookingDto), HttpStatus.OK);

	}

	/*
	 * Method for deleting booking object with given booking id -DELETE
	 */
	@DeleteMapping("/booking/cancel/{id}")
	public String deleteBookingById(@Valid @PathVariable("id") int bookingId) {
		
			bookingServ.cancelBooking(bookingId);

			return "Deleted booking record success";
		
	}

	/*
	 * Method for updating booking object with given booking id-PUT
	 */
	@PutMapping("/booking/update")
	public String updateBooking(@Valid @RequestBody Booking book) {
	
			new ResponseEntity<>(bookingServ.updateBooking(book), HttpStatus.OK);
			return "Update success";
	}

	/*
	 * Method for getting booking record with given booking id-GET
	 */
	@GetMapping("/booking/bookingById/{id}")
	public ResponseEntity<?> getBookingById(@Valid @PathVariable("id") int bookingId) {
		return new ResponseEntity<>(bookingServ.viewBooking(bookingId), HttpStatus.OK);
	}

	/*
	 * Method for getting all booking records present-GET
	 */
	@GetMapping("/booking/all")
	public ResponseEntity<?> getAllBookings() {

		return new ResponseEntity<>(bookingServ.viewAllBooking(), HttpStatus.OK);
	}

	/*
	 * Method for getting booking records with given booking date-GET
	 */
	@GetMapping("/booking/byDate/{date}")
	public ResponseEntity<?> getAllBookingsByDate(@Valid @PathVariable("date") String bookDate) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");
			LocalDate localDate = LocalDate.parse(bookDate, formatter);

			return new ResponseEntity<>(bookingServ.viewAllBookingByDate(localDate), HttpStatus.OK);
		} catch (DateTimeParseException e) {
			logger.error("Invalid Date Input", e.getCause());
			return new ResponseEntity<>("Date not in given format", HttpStatus.EXPECTATION_FAILED);
		}

	}

	/*
	 * Method for getting customer details with given booking id-GET
	 */
	@GetMapping("/booking/CustomerDetails/{bookingId}")
	public ResponseEntity<?> getCustomerByBookingId(@Valid @PathVariable("bookingId") int bookingId) {

		return new ResponseEntity<>(bookingServ.viewCustomerDetailsByBookingId(bookingId), HttpStatus.OK);

	}

	/*
	 * Method for getting vehicle record with given booking id-GET
	 */
	@GetMapping("/booking/VehicleDetails/{bookingId}")
	public ResponseEntity<?> getVehicleByBookingId(@Valid @PathVariable("bookingId") int bookingId) {

		return new ResponseEntity<>(bookingServ.viewVehicleDetailsByBookingId(bookingId), HttpStatus.OK);
	}

	/*
	 * Method for getting driver record with given booking id-GET
	 */
	@GetMapping("/booking/DriverDetails/{bookingId}")
	public ResponseEntity<?> getDriverByBookingId(@Valid @PathVariable("bookingId") int bookingId) {

		return new ResponseEntity<>(bookingServ.viewDriverDetailsByBookingId(bookingId), HttpStatus.OK);

	}

	/*
	 * Method for getting driver record with given booking id-GET
	 */
	@GetMapping("/booking/BookingStatus/{bookingId}")
	public ResponseEntity<BookingBookingStatusDto> getBookingStatusById(
			@Valid @PathVariable("bookingId") int bookingId) {

		return new ResponseEntity<BookingBookingStatusDto>(bookingServ.viewBookingStatusByBookingId(bookingId),
				HttpStatus.OK);

	}

}