package com.vrs.service;

import com.vrs.entities.*;
import java.util.List;

public interface ICustomerService {
	// Adding Customer
	public Customer addCustomer(Customer customer);

	// Removing Customer by ID
	public Customer removeCustomer(int customerId);

	// Viewing a Customer by ID
	public Customer viewCustomer(int customerId);

	// Viewing a Customer by Email
	public Customer getCustomerByEmail(String email);

	// Updating Customer
	public Customer updateCustomer(Customer customer);

	// Viewing All Customers
	public List<Customer> viewAllCustomer();

	// Viewing Customers based on Location
	public List<Customer> viewAllCustomersByLocation(String city);

	// Viewing Booking details based on given CustomerId
	public List<Booking> viewAllBooking(int customerId);

	// Viewing Vehicle details based on given CustomerId
	public List<Vehicle> viewAllVehicle(int customerId);

}
