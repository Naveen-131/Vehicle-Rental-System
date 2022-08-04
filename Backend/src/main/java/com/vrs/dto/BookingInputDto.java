package com.vrs.dto;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

/*
*getting booking data and giving this to servie layer of booking as input
*/
public class BookingInputDto {

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

	private int customerId=0;

	public BookingInputDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingInputDto(@Min(2000) @Max(9000) int bookingId, LocalDate bookingDate, LocalDate bookedTillDate,
			@Size(min = 3, message = "required") String bookingDescription,
			@NotEmpty @Size(min = 2, message = "either pick-up/home-deliver") String deliveryMode,
			@DecimalMax("10000.0") @DecimalMin("0.0") @Positive(message = "cost should be positive") double totalCost,
			@DecimalMax("1000.0") @DecimalMin("0.0") double distance, int customerId) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.bookingDescription = bookingDescription;
		this.deliveryMode = deliveryMode;
		this.totalCost = totalCost;
		this.distance = distance;
		this.customerId = customerId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public java.time.LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(java.time.LocalDate bookingDate) {
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	@Override
	public String toString() {
		return "BookingInputDto [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookedTillDate="
				+ bookedTillDate + ", bookingDescription=" + bookingDescription + ", deliveryMode=" + deliveryMode
				+ ", totalCost=" + totalCost + ", distance=" + distance + ", customerId=" + customerId + "]";
	}

}
