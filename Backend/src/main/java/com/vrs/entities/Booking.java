package com.vrs.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

//For generating Getters , Setters , Constructors etc. 
@Entity
public class Booking {

	// Annotation for specifying bookingId as a primary key
	// validating booking id
	@Id
	// @GeneratedValue
	@NotNull
	@Min(2000)
	@Max(9000)
	private int bookingId;

	// validating booking date
	@NotNull
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private java.time.LocalDate bookingDate;

	// validating booking till date
	@NotNull
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private LocalDate bookedTillDate;

	// validate description
	@Size(min = 3, message = "required")
	private String bookingDescription;

	// validate delivery mode
	@NotEmpty
	@Size(min = 2, message = "either pick-up/home-deliver")
	private String deliveryMode;

	// validating total cost
	@NotNull
	@DecimalMax("10000.0")
	@DecimalMin("0.0")
	@Positive(message = "cost should be positive")
	private double totalCost;

	// validating distance
	@NotNull
	@DecimalMax("1000.0")
	@DecimalMin("0.0")
	private double distance;

	@JsonIgnore
	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
//	@JoinColumn(name = "payment_id_fk")
	private Payment payment;

	@JsonIgnore
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<>();

	// @JsonIgnore
	@OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	private ActiveBooking activeBooking;

	/*
	 * @ManyToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="vehicle_id_fk") private Vehicle vehicles;
	 */

	@JsonIgnore
	// @Column(nullable=false)
	@ManyToOne()
	@JoinColumn(name = "customer_id_fk")
	private Customer customer;

	public Booking() {
		super();

	}

	public Booking(@Min(2000) @Max(9000) int bookingId, LocalDate bookingDate, LocalDate bookedTillDate,
			@Size(min = 3, message = "required") String bookingDescription,
			@NotEmpty @Size(min = 2, message = "either pick-up/home-deliver") String deliveryMode,
			@DecimalMax("10000.0") @DecimalMin("0.0") @Positive(message = "cost should be positive") double totalCost,
			@DecimalMax("1000.0") @DecimalMin("0.0") double distance, Payment payment, List<Vehicle> vehicles,
			ActiveBooking activeBooking, Customer customer) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.deliveryMode = deliveryMode;
		this.totalCost = totalCost;
		this.distance = distance;
		this.payment = payment;
		this.vehicles = vehicles;
		this.activeBooking = activeBooking;
		this.customer = customer;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getBookedTillDate() {
		return bookedTillDate;
	}

	public void setBookedTillDate(LocalDate bookedTillDate) {
		this.bookedTillDate = bookedTillDate;
	}

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/*
	 * public ActiveBooking getActiveBooking() { return activeBooking; }
	 */

	public void setActiveBooking(ActiveBooking activeBooking) {
		this.activeBooking = activeBooking;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookedTillDate=" + bookedTillDate
				+ ", bookingDescription=" + bookingDescription + ", delivery option=" + deliveryMode + ", totalCost="
				+ totalCost + ", distance=" + distance + "]";
	}

}
