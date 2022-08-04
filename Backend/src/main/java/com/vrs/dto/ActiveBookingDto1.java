package com.vrs.dto;




public class ActiveBookingDto1 {

	//fields
	private int activeBookingId;
	private String status;
	
	private String bookingDescription;
	
	//constructors
	public ActiveBookingDto1()
	{
		super();
	}

	public ActiveBookingDto1(int activeBookingId, String status, String bookingDescription) {
		super();
		this.activeBookingId = activeBookingId;
		this.status = status;
		this.bookingDescription = bookingDescription;
	}
	
	
// getters and setters
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

	public String getBookingDescription() {
		return bookingDescription;
	}

	public void setBookingDescription(String bookingDescription) {
		this.bookingDescription = bookingDescription;
	}

	//toString
	@Override
	public String toString() {
		return "ActiveBookingDto1 [activeBookingId=" + activeBookingId + ", statu=" + status
				+ ", bookingDescription=" + bookingDescription + "]";
	}
	
	
	

}
