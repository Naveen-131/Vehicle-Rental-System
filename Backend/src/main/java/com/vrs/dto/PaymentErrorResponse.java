package com.vrs.dto;

public class PaymentErrorResponse {
	/*
	 * PaymentError File is providing the error in user friendly format
	 */

	private int status;
	private String message;
	private long timeStamp;

	public PaymentErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "PaymentErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}

}
