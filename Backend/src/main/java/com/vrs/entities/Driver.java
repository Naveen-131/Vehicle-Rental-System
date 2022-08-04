package com.vrs.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Driver {
	// Annotation for specifying driverId as a primary key
	@Id
	// Annotation for auto generation of primary key
	@GeneratedValue
	private int driverId;
	// Validating first name
	@NotEmpty
	@Size(min = 2, message = "driver's first name should have atleast 2 characters")
	@Pattern(regexp = "^[a-zA-Z\\\\s]{2,}$", message = "Please enter valid First Name")
	private String firstName;
	// Validating last name
	@NotEmpty(message = "Last name cannot be empty")
	@Pattern(regexp = "^[a-zA-Z\\\\s]{1,}$", message = "Please enter valid Last Name")
	private String lastName;
	// Validating Indian contact numbers
	@NotEmpty(message = "Contact number cannot be empty")
	@Pattern(regexp = "^[+]?[0]?(91)?[789][\\d]{9}$", message = "Please enter valid contact number")
	private String contactNumber;
	// Validating email address
	@Email
	private String email;
	private String address;
	// validating price
	@Positive(message = "price should be positive")
	private double chargesPerDay;
	// Validating Indian license number
	@NotEmpty(message = "license number cannot be empty")
	@Pattern(regexp = "^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$", message = "Please enter valid license number")
	@Size(min = 15, max = 16, message = "license number should be of 16 characters including space or hyphen")
	private String licenseNo;
	// one to one mapping with vehicle
	@JsonIgnore
	@OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
	private Vehicle vehicle;

	// constructor
	public Driver(int driverId, String firstName, String lastName, String contactNumber, String email, String address,
			double chargesPerDay, String licenseNo) {
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.chargesPerDay = chargesPerDay;
		this.licenseNo = licenseNo;
	}

	public Driver(int driverId,
			@NotEmpty @Size(min = 2, message = "driver's first name should have atleast 2 characters") @Pattern(regexp = "^[a-zA-Z\\\\s]{2,}$", message = "Please enter valid First Name") String firstName,
			@NotEmpty(message = "Last name cannot be empty") @Pattern(regexp = "^[a-zA-Z\\\\s]{1,}$", message = "Please enter valid Last Name") String lastName,
			@NotEmpty(message = "Contact number cannot be empty") @Pattern(regexp = "^[+]?[0]?(91)?[789][\\d]{9}$", message = "Please enter valid contact number") String contactNumber,
			@Email String email, String address, @Positive(message = "price should be positive") double chargesPerDay,
			@NotEmpty(message = "license number cannot be empty") @Pattern(regexp = "^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$", message = "Please enter valid license number") @Size(min = 15, max = 16, message = "license number should be of 16 characters including space or hyphen") String licenseNo,
			Vehicle vehicle) {
		super();
		this.driverId = driverId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.address = address;
		this.chargesPerDay = chargesPerDay;
		this.licenseNo = licenseNo;
		this.vehicle = vehicle;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getChargesPerDay() {
		return chargesPerDay;
	}

	public void setChargesPerDay(double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", address=" + address + ", chargesPerDay="
				+ chargesPerDay + ", licenseNo=" + licenseNo + ", vehicle=" + vehicle + "]";
	}
}
