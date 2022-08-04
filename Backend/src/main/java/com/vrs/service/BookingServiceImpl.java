package com.vrs.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrs.dao.IActiveBookingRepository;
import com.vrs.dao.IBookingRepository;
import com.vrs.dao.ICustomerRepository;
import com.vrs.dto.BookingBookingStatusDto;
import com.vrs.dto.BookingInputDto;
import com.vrs.dto.CustomerBookingDto;
import com.vrs.entities.ActiveBooking;
import com.vrs.entities.Booking;
import com.vrs.entities.Customer;
import com.vrs.entities.Driver;
import com.vrs.entities.Vehicle;
import com.vrs.exception.BookingFoundException;
import com.vrs.exception.BookingNotFoundException;
import com.vrs.exception.BookingVehicleNotFoundException;
import com.vrs.exception.CustomerNotFoundException;
import com.vrs.exception.NegativeNumberException;

@Service
public class BookingServiceImpl implements IBookingService {

	// it a static method which initializes the logger
	private static final Logger logger = LogManager.getLogger(BookingServiceImpl.class);

	// used to auto connect the doa functionalities to the service layer
	@Autowired
	IBookingRepository bookingDao;

	@Autowired
	ICustomerRepository customerDao;

	@Autowired
	IActiveBookingRepository activebookingDao;

	/*
	 * add booking object
	 */
	@Override
	public Booking addBooking(BookingInputDto bookingDto) {
		if (bookingDto.getBookingId() < 1 || (bookingDto.getBookingDate().isBefore(LocalDate.parse("2021-08-01"))) ||  (bookingDto.getBookedTillDate().isBefore(bookingDto.getBookingDate()))) // if entered data is negative throw exception for it
		{
			logger.error("Booking id entered was negative  and booking date entered is invalid");

			throw new NegativeNumberException("input cannot be negative");
		} else {
			logger.info("begin add booking");

			Optional<Booking> opt = bookingDao.findById(bookingDto.getBookingId()); // optional: default container that
																					// holds any object of any type
			if (opt.isPresent()) {
				logger.error("Failed to add booking record with booking id" + bookingDto.getBookingId());
				throw new BookingFoundException(
						"Booking already exists with the given Booking Id: " + bookingDto.getBookingId());
			} else {

				
				  Optional<Customer> cust = customerDao.findById(bookingDto.getCustomerId());
				  if (!cust.isPresent()) { throw new CustomerNotFoundException(
				  "Customer does not exists with the given Customer Id: " +
				  bookingDto.getCustomerId()); } else { if (bookingDto.getCustomerId() < 1) {
				  logger.error("Cusotmer id entered was negative");
				  
				  throw new NegativeNumberException("input cannot be negative"); }
				 
					Booking book = new Booking();

					Optional<Customer> customer = customerDao.findById(bookingDto.getCustomerId());
					book.setBookingId(bookingDto.getBookingId());
					book.setBookingDate(bookingDto.getBookingDate());
					book.setBookedTillDate(bookingDto.getBookedTillDate());
					book.setBookingDescription(bookingDto.getBookingDescription());
					book.setDeliveryMode(bookingDto.getDeliveryMode());
					book.setDistance(bookingDto.getDistance());
					book.setTotalCost(bookingDto.getTotalCost());
					book.setCustomer(customer.get());
					bookingDao.save(book);
					logger.info("Successfully entered with booking id" + bookingDto.getBookingId());
					ActiveBooking activeBook = new ActiveBooking();
					activeBook.setStatus("Pending");
					activeBook.setActiveBookingId(4);
					activeBook.setBooking(book);
					activebookingDao.save(activeBook);
					logger.info("Successfully updated status for booking id" + bookingDto.getBookingId());
					return book;
				}
			}
		}
	}

	/*
	 * cancel booking
	 */
	@Override
	public Booking cancelBooking(int bookingId) {
		if (bookingId < 1) {
			logger.error("Booking id entered was negative");

			throw new NegativeNumberException("input cannot be negative");
		} else {
			logger.info("begin cancel bookoking");
			Optional<Booking> opt = bookingDao.findById(bookingId);
			if (opt.isPresent()) {
				bookingDao.deleteById(bookingId);
				logger.info("Successfully deleted booking id" + bookingId);
				return null;
			} else {
				logger.error("error while deleting record since record not found");
				throw new BookingNotFoundException("Booking Record Not Found with Booking Id " + bookingId);

			}
		}
	}

	/*
	 * update booking
	 */
	@Override
	public Booking updateBooking(Booking b) {
		if (b.getBookingId() < 1 || (b.getBookingDate().isBefore(LocalDate.parse("2021-08-01"))) ||  (b.getBookedTillDate().isBefore(b.getBookingDate()))) // if entered data is negative throw exception for it
		{
			logger.error("Booking id entered was negative");

			throw new NegativeNumberException("input cannot be negative and booking date entered is invalid");
		} else {
			logger.info("begin cancel bookoking");
			Optional<Booking> f = bookingDao.findById(b.getBookingId());
			if (f.isPresent()) {
				Booking dbBooking = f.get();

				dbBooking.setBookingId(b.getBookingId());
				dbBooking.setBookingDate(b.getBookingDate());
				dbBooking.setBookedTillDate(b.getBookedTillDate());
				dbBooking.setBookingDescription(b.getBookingDescription());
				dbBooking.setDistance(b.getDistance());

				dbBooking.setTotalCost(b.getTotalCost());

				bookingDao.save(dbBooking);
				logger.info("successfully updated with booking id" + b.getBookingId());
				return b;

			} else {
				logger.error("Error while updating,booking not found with id");
				throw new BookingNotFoundException(
						"Error while updating,booking not found with id:" + b.getBookingId());
			}
		}
	}

	/*
	 * view booking by booking id
	 */
	@Override
	public Booking viewBooking(int bookId) {

		logger.info("begin view booking by id");
		if (bookId < 1) {
			logger.error("Booking id entered was negative");

			throw new NegativeNumberException("input cannot be negative");
		} else {
			Optional<Booking> opt = bookingDao.findById(bookId);
			if (!opt.isPresent()) {
				logger.warn("Booking not found");
				throw new BookingNotFoundException("Booking not found with given id: " + bookId);
			}
			logger.info("Successfully found booking details by Booking Id");
			return bookingDao.findById(bookId).get();
		}
	}

	/*
	 * view all bookings
	 */
	@Override
	public List<Booking> viewAllBooking() {
		logger.info("begin view all booking");
		try {
			List<Booking> opt = (List<Booking>) bookingDao.findAll();
			if (opt.isEmpty()) {
				logger.error("No booking records");
				throw new BookingNotFoundException("Currently No Bookings");
			} else {
				logger.info("Bookings Found");
				return (List<Booking>) bookingDao.findAll();
			}
		} catch (Exception e) {
			logger.error("Error while getting booking records", e.getCause());
			throw new BookingNotFoundException("Something went wrong,Please try again.");

		}

	}

	/*
	 * view bookings based on a given date
	 */
	@Override
	public List<Booking> viewAllBookingByDate(LocalDate bookingDate) {

		logger.info("begin view booking by date");

		List<Booking> opt = bookingDao.findAllBookingsByDate(bookingDate);
		if (opt.isEmpty()) {
			logger.error("No booking with date:" + bookingDate);
			throw new BookingNotFoundException("Booking not found with given date: " + bookingDate);
		}
		logger.info("Entry found with given date:" + bookingDate);
		return bookingDao.findAllBookingsByDate(bookingDate);

	}

	// view customer details by booking id
	@Override
	// public CustomerBookingDto viewCustomerDetailsByBookingId(int bookingId) {
	public CustomerBookingDto viewCustomerDetailsByBookingId(int bookingId) {
		logger.info("begin customer details by booking id");
		if (bookingId < 1) {
			logger.error("Booking id entered was negative");

			throw new NegativeNumberException("input cannot be negative");
		} else {
			Optional<Booking> opt = bookingDao.findById(bookingId);
			if (!opt.isPresent()) {
				logger.error("Customer not found with id: " + bookingId);
				throw new BookingNotFoundException("Customer not found with given Booking Id: " + bookingId);
			}
			logger.info("Found Customer who has booking");
			return bookingDao.findCustomerByBookingId(bookingId);
		}
	}

	/*
	 * view vehicle details by given booking id
	 */
	@Override
	// public BookingVehicleDto viewVehicleDetailsByBookingId(int bookingId) {
	public Vehicle viewVehicleDetailsByBookingId(int bookingId) {
		if (bookingId < 1) {
			logger.error("Booking id entered was negative");

			throw new NegativeNumberException("input cannot be negative");
		} else {
			logger.info("begin vehicle details by booking id");
			Optional<Booking> opt = bookingDao.findById(bookingId);
			if (opt == null) {
				logger.error("Vehicle not found with id: " + bookingId);
				throw new BookingNotFoundException("Customer not found with given Booking Id: " + bookingId);
			} else {
				if (bookingDao.findVehicleByBookingId(bookingId) == null) {
					logger.error("Vehicle not alloted");
					throw new BookingVehicleNotFoundException("Vehicle not alloted for given Booking Id:" + bookingId);
				} else {
					logger.info("Found Vehicle");
					return bookingDao.findVehicleByBookingId(bookingId);
				}
			}
		}
	}

	/*
	 * view driver detail by given booking id
	 */
	@Override
	public Driver viewDriverDetailsByBookingId(int bookingId) {
		logger.info("Driver details by booking id");
		if (bookingId < 1) {
			logger.error("Booking id entered was negative");

			throw new NegativeNumberException("input cannot be negative");
		} else {
			Driver opt = bookingDao.findDriverByBookingId(bookingId);

			if (opt == null) {
				logger.error("driver not found for booking id: " + bookingId);
				throw new BookingNotFoundException("Driver not found with given Booking Id: " + bookingId);
			}

			else {

				if (bookingDao.findDriverByBookingId(bookingId) == null) {
					logger.error("driver not alloted for booking id: " + bookingId);
					throw new BookingVehicleNotFoundException("Driver not alloted for given Booking Id:" + bookingId);
				} else {
					logger.info("Found driver details with booking id:" + bookingId);
					return bookingDao.findDriverByBookingId(bookingId);
				}
			}
		}
	}

	/*
	 * view booking status by given booking id
	 */
	@Override
	public BookingBookingStatusDto viewBookingStatusByBookingId(int bookingId) {
		logger.info("booking status with booking id:" + bookingId);
		if (bookingId < 1) {
			logger.error("Booking id entered was negative");

			throw new NegativeNumberException("input cannot be negative");
		} else {
			Optional<Booking> opt = bookingDao.findById(bookingId);
			if (opt == null) {
				logger.error("Booking not found");
				throw new BookingNotFoundException("Booking not found with given id: " + bookingId);
			}
			logger.info("Successfully found booking status by Booking Id" + bookingId);
			return bookingDao.findBookingStatusByBookingId(bookingId);
		}
	}
}
