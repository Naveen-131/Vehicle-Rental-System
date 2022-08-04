package com.vrs.controller;

import javax.validation.Valid;

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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vrs.entities.Customer;
import com.vrs.exception.CustomerNotFoundException;
import com.vrs.service.ICustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {

	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	@Autowired
	ICustomerService customerServ;

	// Add customer - Post
	// Here we use POST to add data to the database
	@PostMapping("/customer") // declaring the mapping type as post and EndPoint as customer
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		try {

			return new ResponseEntity<>(customerServ.addCustomer(customer), HttpStatus.OK);
		} catch (CustomerNotFoundException e) {
			logger.error("Didnt Add a Customer", e.getCause());
			return new ResponseEntity<>("Something went wrong,Please try again.", HttpStatus.EXPECTATION_FAILED);
		}

	}

	// Remove customer by customer ID - Delete
	// Here we use DELETE to remove data of customer from the database
	@DeleteMapping("/customer/remove/{id}")
	public String deleteCustomerById(@Valid @PathVariable("id") int customerId) {
		// return new ResponseEntity<>(bookingServ.cancelBooking(bookingId) ,
		// HttpStatus.OK);
		try {
			customerServ.removeCustomer(customerId);
			return "Deleted booking record success";
		} catch (CustomerNotFoundException e) {
			logger.error("Didnt remove a Customer", e.getCause());
			return e.toString();
		}
	}

	// Update employee details - Put
	// Here we use PUT to update data to the database
	@PutMapping("/customer/update")
	public ResponseEntity<?> updateCustomer(@Valid @RequestBody Customer customer) {

		try {

			return new ResponseEntity<>(customerServ.updateCustomer(customer), HttpStatus.OK);
		} catch (CustomerNotFoundException e) {

			logger.error("error updating customer record", e.getCause());
			return new ResponseEntity<>("Something went wrong,Please try again.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	// View Customer based on ID - Get
	// Here we use GET to view single employee data from the database
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> viewCustomer(@PathVariable("id") int customerId) {

		try {

			return new ResponseEntity<>(customerServ.viewCustomer(customerId), HttpStatus.OK);

		} catch (CustomerNotFoundException e) {

			logger.error("Customer not found", e.getCause());
			return new ResponseEntity<>("Something went wrong,Please try again.", HttpStatus.EXPECTATION_FAILED);

		}
	}

	// Get customer based on Email - get
	// Here we use GET to view customer with given email data from the database
	@GetMapping("/customer/byEmail/{email}")
	public ResponseEntity<?> getCustomerByEmail(@PathVariable("email") String email) {
		try {
			return new ResponseEntity<>(customerServ.getCustomerByEmail(email), HttpStatus.OK);
		} catch (CustomerNotFoundException e) {

			logger.error("Customer not found with given email", e.getCause());
			return new ResponseEntity<>("Customer not found with given email", HttpStatus.EXPECTATION_FAILED);

		}
	}

	// Here we use GET to view ALL customer data from the database
	@GetMapping("/customer/all")
	public ResponseEntity<?> viewAllCustomer() {

		try {

			return new ResponseEntity<>(customerServ.viewAllCustomer(), HttpStatus.OK);
		} catch (CustomerNotFoundException e) {

			logger.error("No data found", e.getCause());
			return new ResponseEntity<>("Something went wrong,Please try again.", HttpStatus.EXPECTATION_FAILED);

		}
	}

	// Get Customers based on Location - Get
	// Here we use GET to view ALL customer in specific location data from the
	// database
	@GetMapping("/customer/byLocation/{city}")
	public ResponseEntity<?> viewCustomerByLocation(@PathVariable("city") String city) {
		try {

			return new ResponseEntity<>(customerServ.viewAllCustomersByLocation(city), HttpStatus.OK);
		} catch (CustomerNotFoundException e) {

			logger.error("No data found with given location", e.getCause());
			return new ResponseEntity<>("Something went wrong,Please try again.", HttpStatus.EXPECTATION_FAILED);
		}
	}

	// to view all booking details by inputting customerID
	@GetMapping("/customer/getbookingdetails/{customerId}")
	public ResponseEntity<?> viewBookingByCustomerId(@PathVariable("customerId") int customerId) {
		try {

			return new ResponseEntity<>(customerServ.viewAllBooking(customerId), HttpStatus.OK);
		} catch (CustomerNotFoundException e) {

			logger.error("No data of booking found of customer ", e.getCause());
			return new ResponseEntity<>("Something went wrong,Please try again.", HttpStatus.EXPECTATION_FAILED);
		}

	}

	// to view all vehicle details by inputting customerID
	@GetMapping("/customer/getVehicledetails/{customerId}")
	public ResponseEntity<?> viewVehicleByCustomerId(@PathVariable("customerId") int customerId) {

		try {

			return new ResponseEntity<>(customerServ.viewAllVehicle(customerId), HttpStatus.OK);
		} catch (CustomerNotFoundException e) {

			logger.error("No data of booking found of customer with vehicle details ", e.getCause());
			return new ResponseEntity<>("Something went wrong,Please try again.", HttpStatus.EXPECTATION_FAILED);
		}

	}

}