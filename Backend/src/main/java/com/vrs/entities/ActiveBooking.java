package com.vrs.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity // For specifying class as an entity
public class ActiveBooking {
	// fields
	@Id
	@NotNull
	@GeneratedValue
	private int activeBookingId;

	// @JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id_fk")
	private Booking booking;

	@NotNull
	@Column(name = "status")
	private String status = "PENDING";

	public ActiveBooking() {
	}

	public ActiveBooking(@NotNull int activeBookingId,
			@NotEmpty(message = "Status cannot be empty,it should be pending or inprogress or completed or cancelled") String status) {
		super();
		this.activeBookingId = activeBookingId;
		this.status = status;
	}

	public int getActiveBookingId() {
		return activeBookingId;
	}

	public void setActiveBookingId(int activeBookingId) {
		this.activeBookingId = activeBookingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBooking() {
		return booking.getBookingId();
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "ActiveBooking [activeBookingId=" + activeBookingId + ", status=" + status + ", bookingId="
				+ booking.getBookingId() + "]";
	}

}