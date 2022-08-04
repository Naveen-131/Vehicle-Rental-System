package com.vrs.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vehicle {

	// Annotation for specifying driverId as a primary key
	@Id
	// Annotation for auto generation of primary key
	@GeneratedValue
	private int vehicleId;

	// Vehicle Number can not be empty
	@NotEmpty
	// Vehicle Number must be in this pattern [TN 23 AC 1231]
	@Pattern(regexp = "^[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}$", message = "Invaild Vehicle Number. Vehicel number should be in this format(TN 23 CF 1313)")
	private String vehicleNumber;

	// Vehicle type cannot be empty and it should contain only characters
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle type.It should contain only Character")
	private String type;

	// Vehicle category cannot be empty and it should contain only characters
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle Category.It should contain only Character")
	private String category;

	@NotEmpty(message = "Vehicle description cannot be Empty")
	private String description;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle Location.It should contain only Character")
	private String location;

	@NotNull(message = "Capacity cannot be null")
	// @Min(2)
	private int capacity;

	@NotNull(message = "Charges per Kilometer cannot be null")
	@Min(10)
	private double chargesPerKM;

	@NotNull(message = "Fixed charges cannot be null")

	@Min(200)
	private double fixedCharges;

	// many to one mapping with booking

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id_fk")
	@JsonIgnore
	private Booking booking;

	// one to one mapping with driver
	@JsonIgnore
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "driver_id_fk")
	private Driver driver;

	public Vehicle(int vehicleId,
			@NotEmpty @Pattern(regexp = "^[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}$", message = "Invaild Vehicle Number. Vehicel number should be in this format(TN 23 CF 1313)") String vehicleNumber,
			@NotEmpty @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle type.It should contain only Character") String type,
			@NotEmpty @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle Category.It should contain only Character") String category,
			@NotEmpty(message = "Vehicle description cannot be Empty") String description,
			@NotEmpty @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle Location.It should contain only Character") String location,
			@NotNull(message = "Capacity cannot be null") int capacity,
			@NotNull(message = "Charges per Kilometer cannot be null") @Min(10) double chargesPerKM,
			@NotNull(message = "Fixed charges cannot be null") @Min(200) double fixedCharges, Booking booking,
			Driver driver) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
		this.booking = booking;
		this.driver = driver;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getChargesPerKM() {
		return chargesPerKM;
	}

	public void setChargesPerKM(double chargesPerKM) {
		this.chargesPerKM = chargesPerKM;
	}

	public double getFixedCharges() {
		return fixedCharges;
	}

	public void setFixedCharges(double fixedCharges) {
		this.fixedCharges = fixedCharges;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", type=" + type + ", category="
				+ category + ", description=" + description + ", location=" + location + ", capacity=" + capacity
				+ ", chargesPerKM=" + chargesPerKM + ", fixedCharges=" + fixedCharges + ", booking=" + booking
				+ ", driver=" + driver + "]";
	}

}
