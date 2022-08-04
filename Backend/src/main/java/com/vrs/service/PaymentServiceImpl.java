package com.vrs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vrs.dao.IBookingRepository;
import com.vrs.dao.IPaymentRepository;
//import com.vrs.dao.IVehicleRepository;
import com.vrs.dto.PaymentDto;
import com.vrs.entities.Booking;
import com.vrs.entities.Payment;
import com.vrs.exception.BookingIdException;
import com.vrs.exception.PaymentDoneForBookingException;
import com.vrs.exception.PaymentIdException;
import com.vrs.util.RentalConstants;

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository prepo;
	@Autowired
	private IBookingRepository brepo;

	/*
	 * @Autowired private IVehicleRepository vrepo;
	 */
	@Override
	public Booking addPayment(PaymentDto paymentDto) throws BookingIdException, PaymentDoneForBookingException {
		Optional<Booking> b1 = brepo.findById(paymentDto.getBookingId());
		if (!b1.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
		List<Payment> p = prepo.findByBooking(b1.get());
		if (!p.isEmpty())
			throw new PaymentDoneForBookingException(RentalConstants.PAYMENT_DONE_FOR_BOOKING);
		Payment p1 = new Payment();
		p1.setPaymentDate(paymentDto.getPaymentDate());
		p1.setPaymentId(paymentDto.getPaymentId());
		p1.setPaymentMode(paymentDto.getPaymentMode());
		p1.setPaymentStatus(paymentDto.getPaymentStatus());
		p1.setBooking(b1.get());
		Payment p2 = prepo.save(p1);
		b1.get().setPayment(p2);
		return p2.getBooking();
	}

	@Override
	public String cancelPayment(Integer pid) throws PaymentIdException {
		Optional<Payment> p1 = prepo.findById(pid);
		if (!p1.isPresent())
			throw new PaymentIdException(RentalConstants.PAYMENT_NOT_FOUND);
		prepo.delete(p1.get());
		String response = "Payment with id" + pid + "is deleted";
		return response;
	}

	@Override
	public List<Payment> viewPaymentByBooking(Integer bid) throws BookingIdException, PaymentIdException {
		Optional<Booking> b1 = brepo.findById(bid);
		if (!b1.isPresent())
			throw new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);

		List<Payment> p1 = prepo.findByBooking(b1.get());
		if (p1.isEmpty())
			throw new PaymentIdException(RentalConstants.PAYMENT_NOT_FOUND);

		return p1;
	}

	/*
	 * @Override public List<Payment> viewAllPaymentsByVehicle(Integer vid) throws
	 * VehicleNotFoundException, BookingIdException, PaymentIdException {
	 * 
	 * 
	 * Optional<Vehicle> v1=vrepo.findById(vid); if(!v1.isPresent()) throw new
	 * VehicleNotFoundException(RentalConstants.VEHICLE_NOT_FOUND);
	 * Optional<Booking> b1=brepo.findByVehicle(v1.get()); if(!b1.isPresent()) throw
	 * new BookingIdException(RentalConstants.BOOKING_NOT_FOUND);
	 * 
	 * List<Payment> p1=prepo.findByBooking(b1.get()); if(p1.isEmpty()) throw new
	 * PaymentIdException(RentalConstants.PAYMENT_NOT_FOUND);
	 * 
	 * return p1; }
	 * 
	 * public boolean validatePayment(PaymentDto paymentDto) throws
	 * ValidatePaymentException{
	 * 
	 * if(!paymentDto.getPaymentMode().matches("(cash|card|UPI)")) throw new
	 * ValidatePaymentException(RentalConstants.PAYMENT_TYPE_INVALID);
	 * if(!paymentDto.getPaymentStatus().matches("(Pending|Done)")) throw new
	 * ValidatePaymentException(RentalConstants.PAYMENT_STATUS_INVALID);
	 * 
	 * return true; }
	 */

	/*
	 * @Override public double calculateMonthlyRevenue(LocalDate d1, LocalDate d2) {
	 * double totalrevenue = brepo.calculateMonthlyRevenue(d1, d2); return
	 * totalrevenue; }
	 */

	/*
	 * @Override public double calculateTotalPayment(Integer v) throws
	 * VehicleNotFoundException { Optional<Vehicle> v1=vrepo.findById(v);
	 * if(!v1.isPresent()) throw new
	 * VehicleNotFoundException(RentalConstants.VEHICLE_NOT_FOUND); double
	 * totalpayment = brepo.calculateTotalPayment(v); return totalpayment; }
	 */
	@Override
	public List<Payment> viewAllPayments() throws PaymentIdException {
		List<Payment> p1 = prepo.findAll();
		if (p1.isEmpty())
			throw new PaymentIdException(RentalConstants.NO_PAYMENTS);

		return p1;
	}

}