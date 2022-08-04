package com.vrs.dto;

/*
*displays vehicl data  by entring booking id
*/

public class BookingVehicleDto {

	// fields,constructors,getters-setters
	private int vehicleId;
	private String vehicleNumber;
	private String type;// car//bus
	private String category; // ac or nonac
	private String description;
	private String location;
	private String capacity;
	private double chargesPerKM;
	private double fixedCharges;

	public BookingVehicleDto() {
		super();

	}

	public BookingVehicleDto(int vehicleId, String vehicleNumber, String type, String category, String description,
			String location, String capacity, double chargesPerKM, double fixedCharges) {
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

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
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

	@Override
	public String toString() {
		return "BookingVehicleDto [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", type=" + type
				+ ", category=" + category + ", description=" + description + ", location=" + location + ", capacity="
				+ capacity + ", chargesPerKM=" + chargesPerKM + ", fixedCharges=" + fixedCharges + "]";
	}

}
