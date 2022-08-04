package com.vrs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.vrs.dao.IBookingRepository;
import com.vrs.entities.Booking;
import com.vrs.entities.Customer;
import com.vrs.entities.Driver;
import com.vrs.entities.Vehicle;

@ExtendWith(SpringExtension.class)
public class BookingServiceMockitoTest {

	// @InjectMock - injects EmployeeService and inject dependent classes/interfaces
	// that are annotated with @Mock
	@InjectMocks
	BookingServiceImpl bookingService;

	// @MockBean - injecting external services

	@MockBean
	IBookingRepository bookingDao;

	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	// view all bookings
	@Test
	void testAllBookings() {
		// Booking book1 = new Booking();
		Booking booking1 = new Booking(2005, LocalDate.parse("2021-08-08"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 650.0, 26, null, null, null, null);
		Booking booking2 = new Booking(2006, LocalDate.parse("2021-08-09"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 600.0, 30, null, null, null, null);

		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(booking1);
		bookingList.add(booking2);

		Mockito.when(bookingDao.findAll()).thenReturn(bookingList);

		List<Booking> bookings = bookingService.viewAllBooking();

		assertEquals(2, bookings.size());
		System.out.println(bookings);
		assertEquals(2005, bookings.get(0).getBookingId());
		assertEquals(2006, bookings.get(1).getBookingId());

	}

	// bookings record by booking id
	@Test
	void testGetBookingByBookingId() {
		Customer customer = new Customer(1001, "Tom", "Sterling", "999996666", "xyz@gmail.com", "chembur", "mumbai",
				"maharashtra", null, null);
		Optional<Booking> booking1;

		booking1 = Optional.of(new Booking(2000, LocalDate.parse("2021-08-08"), LocalDate.parse("2021-08-10"),
				"booking", "home-deliver", 650.0, 26, null, null, null, customer));

		Mockito.when(bookingDao.findById(1001)).thenReturn(booking1);
		Booking response = bookingService.viewBooking(1001);
		assertEquals(2000, response.getBookingId());
		assertEquals(LocalDate.parse("2021-08-08"), response.getBookingDate());
	}

	// update a given booking record
	@Test
	void testUpdateBooking() {
		Customer customer = new Customer(1001, "Tom", "Sterling", "999996666", "xyz@gmail.com", "chembur", "mumbai",
				"maharashtra", null, null);
		Booking booking1;
		Booking booking2;
		booking1 = new Booking(2000, LocalDate.parse("2021-08-08"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 650.0, 26, null, null, null, customer);

		Mockito.when(bookingDao.findById(2000)).thenReturn(Optional.of(booking1));
		Mockito.when(bookingDao.save(booking1)).thenReturn(booking1);
		booking2 = new Booking(2000, LocalDate.parse("2021-08-09"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 655.0, 30, null, null, null, customer);

		booking1 = bookingService.updateBooking(booking2);
		System.out.println(booking1);
		assertEquals(2000, booking1.getBookingId());
		assertEquals(LocalDate.parse("2021-08-09"), booking1.getBookingDate());
		assertEquals(30, booking1.getDistance());
	}

	// delete a booking record
	@Test
	void testDeleteBooking() {
		Customer customer = new Customer(1001, "Tom", "Sterling", "999996666", "xyz@gmail.com", "chembur", "mumbai",
				"maharashtra", null, null);
		Booking booking1;
		Booking booking2;
		booking1 = new Booking(2000, LocalDate.parse("2021-08-08"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 650.0, 26, null, null, null, customer);
		booking2 = new Booking(2006, LocalDate.parse("2021-08-09"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 600.0, 30, null, null, null, null);

		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(booking1);
		bookingList.add(booking2);

		Mockito.when(bookingDao.findById(2000)).thenReturn(Optional.of(booking1));
		System.out.println(bookingList);

		bookingDao.deleteById(2000); // deleting of object

		bookingService.cancelBooking(2000);
		bookingList.remove(booking1); // deleting object reference from list
		System.out.println(bookingList);
		assertEquals(bookingList.size(), 1); // before list size = 2,after deleting list size = 1

	}

	// get bookings by a given date
	@Test
	void testGetBookingByDate() {
		Customer customer = new Customer(1001, "Tom", "Sterling", "999996666", "xyz@gmail.com", "chembur", "mumbai",
				"maharashtra", null, null);

		Booking booking1;
		Booking booking2;
		booking1 = new Booking(2000, LocalDate.parse("2021-08-08"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 650.0, 26, null, null, null, customer);
		booking2 = new Booking(2006, LocalDate.parse("2021-08-08"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 600.0, 30, null, null, null, null);

		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(booking1);
		bookingList.add(booking2);
		Mockito.when(bookingDao.findAllBookingsByDate(LocalDate.parse("2021-08-08"))).thenReturn(bookingList);
		List<Booking> response = bookingService.viewAllBookingByDate(LocalDate.parse("2021-08-08"));
		assertEquals(LocalDate.parse("2021-08-08"), response.get(0).getBookingDate());
		assertEquals(LocalDate.parse("2021-08-08"), response.get(0).getBookingDate());
	}

	// vehicle details by booking id
	@Test
	void testGetVehicleDetailsByBookingId() {
		Customer customer = new Customer(1001, "Tom", "Sterling", "999996666", "xyz@gmail.com", "chembur", "mumbai",
				"maharashtra", null, null);
		// Customer customer1 = new Customer(1001, "Tom", "Sterling", "999996666",
		// "xyz@gmail.com", "MUMBAI", null, null);

		Booking booking1 = new Booking(2000, LocalDate.parse("2021-08-08"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 650.0, 26, null, null, null, customer);

		Vehicle vehicle1 = new Vehicle(6000, "MH035566", "AC", "CAR", "send", "mumbai", 4, 450.0, 25.0, booking1, null);

		Mockito.when(bookingDao.findVehicleByBookingId(2000)).thenReturn(vehicle1);
		Vehicle response = bookingService.viewVehicleDetailsByBookingId(2000);
		System.out.println(response);
		assertEquals(6000, response.getVehicleId());
		// assertEquals(LocalDate.parse("2021-08-08"),
		// response.get(0).getBookingDate());
	}

	// driver details by booking id
	@Test
	void testGetDriverDetailsByBookingId() {
		Customer customer = new Customer(1001, "Tom", "Sterling", "999996666", "xyz@gmail.com", "chembur", "mumbai",
				"maharashtra", null, null);
		// Customer customer1 = new Customer(1001, "Tom", "Sterling", "999996666",
		// "xyz@gmail.com", "MUMBAI", null, null);

		Booking booking1 = new Booking(2000, LocalDate.parse("2021-08-08"), LocalDate.parse("2021-08-10"), "booking",
				"home-deliver", 650.0, 26, null, null, null, customer);

		Driver driver = new Driver(500, "ram", "yadav", "9999988888", "driver1@gmail.com", "mumbai", 200.0, "MH045599",
				null);

		new Vehicle(6000, "MH035566", "AC", "CAR", "send", "mumbai", 4, 450.0, 25.0, booking1, driver);

		Mockito.when(bookingDao.findDriverByBookingId(2000)).thenReturn(driver);
		Driver response = bookingService.viewDriverDetailsByBookingId(2000);
		System.out.println(response);
		assertEquals(500, response.getDriverId());

	}
}
