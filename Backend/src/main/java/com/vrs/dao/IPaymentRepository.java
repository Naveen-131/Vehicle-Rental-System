package com.vrs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vrs.entities.Booking;
import com.vrs.entities.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findByBooking(Booking booking);
	// List<Payment> findByVehicle(Vehicle vehicle);

}
