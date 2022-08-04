package com.vrs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vrs.entities.*;

public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

	// custom method

	// to get customer by city
	@Query("select c from Customer c where c.city =:city")
	List<Customer> viewCustomerByLocation(@Param("city") String city);

	// to get booking details by customerID
	@Query("select b from Customer e left join Booking b on b.customer = e.customerId where e.customerId =:customerId")
	List<Booking> viewAllBookingByCustomerId(@Param("customerId") int custId);

	// to get vehicle details by customerID
	@Query("select v from Vehicle v where v.booking in (select b.bookingId from Booking b,Customer c where c.customerId = b.customer AND c.customerId=:customerId)")
	List<Vehicle> viewAllVehicleByCustomerId(@Param("customerId") int custId);

	@Query("select c from Customer c where c.emailId =:emailId")
	Customer findbyEmail(@Param("emailId") String emailId);
}
