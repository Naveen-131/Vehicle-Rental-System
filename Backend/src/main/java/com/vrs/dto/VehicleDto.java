package com.vrs.dto;

//import lombok.AllArgsConstructor;
//import lombok.Data;

/*@Data
@AllArgsConstructor*/
public class VehicleDto {

	private int vehicleId;
	private String vehicleNumber;
	private String type;
	private String location;
	private double chargesPerKM;

	private int driverId;
	private String driverName;
	private String contactNumber;
	private String licenseNumber;

	public VehicleDto(int vehicleId, String vehicleNumber, String type, String location, double chargesPerKM,
			int driverId, String driverName, String contactNumber, String licenseNumber) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.location = location;
		this.chargesPerKM = chargesPerKM;
		this.driverId = driverId;
		this.driverName = driverName;
		this.contactNumber = contactNumber;
		this.licenseNumber = licenseNumber;
	}

	public VehicleDto() {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getChargesPerKM() {
		return chargesPerKM;
	}

	public void setChargesPerKM(double chargesPerKM) {
		this.chargesPerKM = chargesPerKM;
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

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	@Override
	public String toString() {
		return "VehicleDto [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", type=" + type
				+ ", location=" + location + ", chargesPerKM=" + chargesPerKM + ", driverId=" + driverId
				+ ", driverName=" + driverName + ", contactNumber=" + contactNumber + ", licenseNumber=" + licenseNumber
				+ "]";
	}

}