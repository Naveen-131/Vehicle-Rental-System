package com.vrs.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Customer {

	@Id
	// @GeneratedValue
	@NotNull
	@Min(1001)
	@Max(9999)
	// @Size(min = 4, max = 4, message = "Customer ID must be of 4 digits")
	private int customerId;

	@NotNull
	@Pattern(regexp = "^[A-Za-z]{3,10}$", message = "Invalid FirstName Input")
	// @Size(max = 10, message = "FirstName is a Required Field")
	private String firstName;

	@NotNull
	@Pattern(regexp = "^[A-Za-z]{1,10}$", message = "Invalid LastName Input")
	// @Size(max = 20, message = "LastName is a Required Field")
	private String lastName;

	@NotNull
	// @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	@Pattern(regexp = "^[7-9][0-9]{9}$") // digits starting from either 7,8,9 in the start and remaining 9 digits
	private String mobileNumber;

	@NotNull
	@Email(message = "Please provide a valid email address") // to make sure email is given in proper format
	private String emailId;

	@NotNull
	// @Size(min = 1,max = 50, message = "Address is a Required Field")
	private String address;

	@NotNull
	// @Size(min= 3,max = 35, message = "City is a Required Field")
	@Pattern(regexp = "^[a-zA-Z]{2,35}$") // So that city has only character input and not integer
	private String city;

	@NotNull
	// @Size(min= 3,max = 35, message = "State is a Required Field")
	@Pattern(regexp = "^[a-zA-Z]{2,35}$") // So that state has only character input and not integer
	private String state;

	// CONSTRUCTORS
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String emailId,
			String address, String city, String state, List<Booking> bookings, User user) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.address = address;
		this.city = city;
		this.state = state;
		this.bookings = bookings;
		this.user = user;
	}

	// GETTERS AND SETTERS
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();

	// @JsonIgnore
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private User user;

	// TOSTRING
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", address=" + address + ", city=" + city
				+ ", State=" + state + ", bookings=" + bookings + ", user=" + user + "]";
	}

}
