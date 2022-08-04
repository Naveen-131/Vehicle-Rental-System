package com.vrs.dto;

import java.time.LocalDate;

public class PaymentDto {
	// primary key
	private Integer paymentId;
	private String paymentMode;
	private LocalDate paymentDate;
	// foreign key
	private Integer bookingId;
	private String paymentStatus;

	public PaymentDto() {
		super();
	}

	public PaymentDto(Integer paymentId, String paymentMode, LocalDate paymentDate, Integer bookingId,
			String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.bookingId = bookingId;
		this.paymentStatus = paymentStatus;
	}

	public PaymentDto(Integer paymentId, String paymentMode, LocalDate paymentDate, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
	}

	public PaymentDto(Integer paymentId) {
		super();
		this.paymentId = paymentId;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}