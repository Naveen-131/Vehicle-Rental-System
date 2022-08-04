package com.vrs.dto;


public class ActiveBookingDto2 {

	//fields
	private int activeBookingId;
	private String status;
	
    private double totalCost;
    
    //constructors
    public ActiveBookingDto2()
    {
    	super();
    }

	public ActiveBookingDto2(int activeBookingId, String statuString, double totalCost) {
		super();
		this.activeBookingId = activeBookingId;
		this.status = statuString;
		this.totalCost = totalCost;
	}
	
	

	//getters and setters
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

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	//toString
	@Override
	public String toString() {
		return "ActiveBookingDto2 [activeBookingId=" + activeBookingId + ", statu=" + status + ", totalCost="
				+ totalCost + "]";
	}
    
    

}
