package com.vrs.service;

import java.util.List;

import com.vrs.dto.PaymentDto;
import com.vrs.entities.Booking;
import com.vrs.entities.Payment;
import com.vrs.exception.BookingIdException;
import com.vrs.exception.PaymentDoneForBookingException;
import com.vrs.exception.PaymentIdException;

public interface IPaymentService {

	public Booking addPayment(PaymentDto paymentDto) throws BookingIdException, PaymentDoneForBookingException;

	public String cancelPayment(Integer pid) throws PaymentIdException;

	public List<Payment> viewPaymentByBooking(Integer bid) throws BookingIdException, PaymentIdException;

//	public List<Payment> viewAllPaymentsByVehicle(Integer vid) throws VehicleNotFoundException, BookingIdException, PaymentIdException;
	public List<Payment> viewAllPayments() throws PaymentIdException;
//	public double calculateMonthlyRevenue(LocalDate d1,LocalDate d2);
//	public double calculateTotalPayment(Integer v) throws VehicleNotFoundException;

}
