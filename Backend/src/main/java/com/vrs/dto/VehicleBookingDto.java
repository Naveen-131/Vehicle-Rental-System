package com.vrs.dto;

import java.time.LocalDate;

/*import lombok.AllArgsConstructor;
import lombok.Data;*/

/*@Data
@AllArgsConstructor*/
public class VehicleBookingDto {

	private int bookingId;
	private LocalDate bookingDate;
	private LocalDate bookedTillDate;
	private double totalCost;

	private int vehicleId;
	private String vehicleNumber;
	private String location;

	private int driverId;
	private String driverName;
	private String contactNumber;

	public VehicleBookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleBookingDto(int bookingId, LocalDate bookingDate, LocalDate bookedTillDate, double totalCost,
			int vehicleId, String vehicleNumber, String location, int driverId, String driverName,
			String contactNumber) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookedTillDate = bookedTillDate;
		this.totalCost = totalCost;
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.location = location;
		this.driverId = driverId;
		this.driverName = driverName;
		this.contactNumber = contactNumber;
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

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "VehicleBookingDto [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookedTillDate="
				+ bookedTillDate + ", totalCost=" + totalCost + ", vehicleId=" + vehicleId + ", vehicleNumber="
				+ vehicleNumber + ", location=" + location + ", driverId=" + driverId + ", driverName=" + driverName
				+ ", contactNumber=" + contactNumber + "]";
	}

}
