package com.vrs.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrs.dto.PaymentDto;
import com.vrs.dto.SuccessMessageDto;
import com.vrs.exception.BookingIdException;
import com.vrs.exception.PaymentDoneForBookingException;
import com.vrs.exception.PaymentIdException;
import com.vrs.service.IPaymentService;
import com.vrs.util.RentalConstants;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

	private static final Logger logger = LogManager.getLogger(PaymentController.class);

	@Autowired
	private IPaymentService pservice;

	// Mapping To Add Payment

	// Adding Payment - Post

	@PostMapping("/add")
	public ResponseEntity<?> addPayment(@RequestBody PaymentDto payment)
			throws BookingIdException, PaymentDoneForBookingException {
		try {
			logger.info("Payment is Sucessfully Added");
			return new ResponseEntity<>(pservice.addPayment(payment), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Payment Cannot be Added", e.getCause());

			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	// Mapping To Cancel Payment

	// Deleting Payment-Delete

	@DeleteMapping("/cancel/{pid}")
	public SuccessMessageDto cancelPayment(@PathVariable Integer pid) throws PaymentIdException {
		try {
			String resp = pservice.cancelPayment(pid);
			logger.info("Payment is Sucessfully Removed");
			return new SuccessMessageDto(RentalConstants.PAYMENT_REMOVED + resp);
		} catch (PaymentIdException e) {
			logger.error("Payment cannot be deleted ", e.getCause());
			return new SuccessMessageDto(RentalConstants.PAYMENT_NOT_FOUND);
		}
	}

	// Mapping To Get Payment By Booking id

	// Getting payment by bookingId-Get

	@GetMapping("/viewByBooking/{bid}")
	public ResponseEntity<?> viewPaymentByBooking(@PathVariable Integer bid)
			throws BookingIdException, PaymentIdException {
		try {
			logger.info("Payments Of Booking are displayed Sucessfully");
			return new ResponseEntity<>(pservice.viewPaymentByBooking(bid), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Booking id not found ", e.getCause());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	// Mapping To Get Payment By Vehicle id

	// Getting payment by vehicleId-Get
	/*
	 * @GetMapping("/viewByVehicle/{vid}") public ResponseEntity<?>
	 * viewAllPaymentsByVehicle(@PathVariable Integer vid) throws
	 * VehicleNotFoundException, BookingIdException, PaymentIdException { try {
	 * logger.info("All Payments Are Displayed"); return new ResponseEntity<>(
	 * pservice.viewAllPaymentsByVehicle(vid),HttpStatus.OK); } catch(Exception e){
	 * logger.error("Vehicle id not found ", e.getCause()); return new
	 * ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED); } }
	 */
	/*
	 * //Mapping To Get Monthly Revenue
	 * 
	 * //Getting Revenue between dates-Get
	 * 
	 * @GetMapping("/calcMonthlyReven/{d1}/{d2}") public ResponseEntity<?>
	 * calculateMonthlyRevenue(@PathVariable(value="d1") @DateTimeFormat(iso =
	 * DateTimeFormat.ISO.DATE) LocalDate
	 * d1, @PathVariable(value="d2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	 * LocalDate d2) { try {
	 * logger.info("Montly Revenue is calulated and Displayed Sucessfully"); return
	 * new ResponseEntity<>(pservice.calculateMonthlyRevenue(d1, d2),HttpStatus.OK);
	 * } catch(Exception e) { logger.error("Enterd Dates in Correct Format ",
	 * e.getCause()); return new
	 * ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED); } }
	 */

	// Mapping To Get TotalPayment of Vehicle by Vehicle id

	// Total Payment of a vehicle-Get

	/*
	 * @GetMapping("/calcTotalPmntByVehicle/{v}") public ResponseEntity<?>
	 * calculateTotalPayment(@PathVariable Integer v) throws
	 * VehicleNotFoundException { try {
	 * logger.info("Total Payment of a Vehicle is shown"); return new
	 * ResponseEntity<>( pservice.calculateTotalPayment(v),HttpStatus.OK); }
	 * catch(Exception e) { logger.error("Vehicle id not found ", e.getCause());
	 * return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED); }
	 * }
	 */
	// Mapping to Get All Payments

	// All Payments - Get

	@GetMapping("/viewAllPayments")
	public ResponseEntity<?> viewAllPayments() throws PaymentIdException {
		try {
			logger.info("All Payments");
			return new ResponseEntity<>(pservice.viewAllPayments(), HttpStatus.OK);

		} catch (Exception e) {
			logger.error("No payments to view as No payments are Added", e.getCause());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.EXPECTATION_FAILED);
		}
	}
}