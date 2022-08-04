package com.vrs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vrs.dao.IBookingRepository;
import com.vrs.dto.CustomerBookingDto;
import com.vrs.entities.Booking;
import com.vrs.entities.Customer;
import com.vrs.entities.Driver;
import com.vrs.entities.Vehicle;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BoookingServiceJunitTest {

	@Autowired
	IBookingService bookingService;

	@Autowired
	IBookingRepository bookingDao;

	// view all bookings
	@Test
	@Order(2)
	void testFindAllBookings() {
		List<Booking> bookings = bookingService.viewAllBooking();
		Assertions.assertEquals(1, bookings.size());
	}

	// bookings record by booking id
	@Test
	@Order(3)
	void testFindBookingById() {
		Booking booking = bookingService.viewBooking(2001);
		Assertions.assertEquals(2002, booking.getBookingId());
		Assertions.assertEquals(LocalDate.parse("2021-08-08"), booking.getBookedTillDate());

	}

	// get bookings by a given date
	@Test
	@Order(4)
	void testFindBookingByBookingDate() {
		List<Booking> booking = bookingService.viewAllBookingByDate(LocalDate.parse("2021-08-08"));
		Assertions.assertEquals(2002, booking.get(0).getBookingId());
		Assertions.assertEquals(LocalDate.parse("2021-08-08"), booking.get(0).getBookedTillDate());

	}

	// vehicle details by booking id
	@Test
	@Order(5)
	void ViewVehicleDetailsByBookingId() {
		Vehicle vehicle = bookingService.viewVehicleDetailsByBookingId(2001);
		Assertions.assertEquals(6000, vehicle.getVehicleId());
		Assertions.assertEquals(100.0, vehicle.getFixedCharges());

	}

	// customer details by booking id
	@Test
	@Order(6)
	void ViewCustomerDetailsByBookingId() {
		CustomerBookingDto cbd = bookingService.viewCustomerDetailsByBookingId(2001);
		Assertions.assertEquals(1001, cbd.getCustomerId());
		Assertions.assertEquals("abc@gmail.com", cbd.getEmailId());

	}

	// driver details by booking id
	@Test
	@Order(7)
	void ViewDriverDetailsByBookingId() {
		Driver driver = bookingService.viewDriverDetailsByBookingId(2001);
		Assertions.assertEquals(500, driver.getDriverId());
		Assertions.assertEquals("driver1@gmail.com", driver.getEmail());

	}

	// update a given booking record
	@Test
	@Order(8)
	void updateBookingById() {
		Customer customer = new Customer(1002, "Jerry", "Sterling", "999997777", "mno@gmail.com", "chembur", "mumbai",
				"maharashtra", null, null);

		Booking b = new Booking(2001, LocalDate.parse("2021-08-09"), LocalDate.parse("2021-08-09"), "booking",
				"home-deliver", 650.0, 26, null, null, null, customer);

		Optional<Booking> f = (bookingDao.findById(2002));
		if (f.isPresent()) {
			Booking dbBooking = f.get();

			dbBooking.setBookingId(b.getBookingId());
			dbBooking.setBookingDate(b.getBookingDate());
			dbBooking.setBookedTillDate(b.getBookedTillDate());
			dbBooking.setBookingDescription(b.getBookingDescription());
			dbBooking.setDistance(b.getDistance());

			dbBooking.setTotalCost(b.getTotalCost());

			bookingDao.save(dbBooking);

			System.out.println(dbBooking);
			Assertions.assertEquals(650.0, dbBooking.getTotalCost());
			Assertions.assertEquals(LocalDate.parse("2021-08-09"), dbBooking.getBookingDate());
			Assertions.assertEquals(LocalDate.parse("2021-08-09"), dbBooking.getBookedTillDate());
		}

	}

	// delete a given booking record
	@Test
	@Order(9)
	void cancelBookingById() {

		bookingService.cancelBooking(2001);
		// Assertions.assertEquals(LocalDate.parse("2021-08-09"),
		// bookingService.viewAllBookingByDate(LocalDate.parse("2021-08-09")));
		// Assertions.assertEquals(, persistedBooking.getTotalCost());

	}

}
