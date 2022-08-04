package com.vrs.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.vrs.controller.CustomerController;
import com.vrs.dao.IBookingRepository;
import com.vrs.dao.ICustomerRepository;
import com.vrs.entities.Booking;
import com.vrs.entities.Customer;
import com.vrs.entities.Vehicle;
import com.vrs.exception.CustomerFoundException;
import com.vrs.exception.CustomerNotFoundException;

@Service
public class CustomerServiceImpl implements ICustomerService {
	private static final Logger logger = LogManager.getLogger(CustomerController.class);

	@Autowired
	ICustomerRepository customerDao;

	@Autowired
	IBookingRepository bookingDao;

	@Override
	public Customer addCustomer(Customer customer) {
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());
		if (opt.isPresent()) {
			throw new CustomerFoundException(
					"Customer already exists with the given Customer Id: " + customer.getCustomerId());
		}
		logger.info("Successful additon of customer data ");
		return customerDao.save(customer);
	}

	@Override
	public Customer removeCustomer(int customerId) {
		Optional<Customer> opt = customerDao.findById(customerId);
		if (opt.isPresent()) {
			customerDao.deleteById(customerId);
			logger.info("Successful deletion of customer data ");
		} else {
			throw new CustomerNotFoundException("Customer Record Not Found with CustomerId " + customerId);

		}
		return null;
	}

	@Override
	public Customer viewCustomer(int customerId) {

		Optional<Customer> opt = customerDao.findById(customerId);
		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer with given ID does not exist" + customerId);
		}
		logger.info("Successful data shown of customer by customerid");
		return opt.get();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// Find customer
		Optional<Customer> opt = customerDao.findById(customer.getCustomerId());

		// Update customer details
		if (opt.isPresent()) {
			Customer dbCust = opt.get();
			dbCust.setFirstName(customer.getFirstName());
			dbCust.setLastName(customer.getLastName());
			dbCust.setMobileNumber(customer.getMobileNumber());
			dbCust.setEmailId(customer.getEmailId());
			dbCust.setAddress(customer.getAddress());
			dbCust.setState(customer.getState());
			dbCust.setCity(customer.getCity());

			// saving updated data of customer
			customerDao.save(dbCust);
			logger.info("Successful upation of customer data using ID " + dbCust.getCustomerId());
		} else {
			throw new CustomerNotFoundException("Currently No Customers with given ID");
		}

		return customer;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		try {
			List<Customer> opt = (List<Customer>) customerDao.findAll();
			if (opt.isEmpty()) {
				throw new CustomerNotFoundException("Currently No Customers");
			} else {

				logger.info("Customers found");
				return (List<Customer>) customerDao.findAll();
			}
		} catch (Exception e) {

			logger.error("No data of booking found of customer with vehicle details ", e.getCause());
			throw new CustomerNotFoundException("Something went wrong,Please try again.");

		}

	}

	@Override
	public List<Customer> viewAllCustomersByLocation(String city) {
		List<Customer> opt = (List<Customer>) customerDao.viewCustomerByLocation(city);
		if (opt.isEmpty()) {
			throw new CustomerNotFoundException("Currently No Customers");
		}
		logger.info("Customers found by location " + city);
		return (List<Customer>) customerDao.viewCustomerByLocation(city);
	}

	@Override
	public List<Booking> viewAllBooking(int customerId) {

		List<Booking> opt = (List<Booking>) customerDao.viewAllBookingByCustomerId(customerId);
		if (opt == null) {
			throw new CustomerNotFoundException("Currently No Customers");
		}
		logger.info("Booking details found");
		return (List<Booking>) customerDao.viewAllBookingByCustomerId(customerId);
	}

	@Override
	public List<Vehicle> viewAllVehicle(int customerId) {
		List<Vehicle> opt = (List<Vehicle>) customerDao.viewAllVehicleByCustomerId(customerId);
		if (opt == null) {
			throw new CustomerNotFoundException("Customer not found with given customer Id: " + customerId);
		} else {
			if ((bookingDao.findById(customerId)) == null) {

				throw new CustomerNotFoundException("Booking not found for given customer" + customerId);
			} else
				logger.info("Found Vehicle");
			return customerDao.viewAllVehicleByCustomerId(customerId);
		}

	}

	@Override
	public Customer getCustomerByEmail(String email) {
		try {
			Optional<Customer> opt = Optional.of(customerDao.findbyEmail(email));
			if (!opt.isPresent()) {
				throw new CustomerNotFoundException("Customer with given email does not exist" + email);
			}
			logger.info("Customer Email Found");
			return opt.get();
		} catch (Exception e) {
			throw new CustomerNotFoundException(e.getMessage());
		}
	}

}