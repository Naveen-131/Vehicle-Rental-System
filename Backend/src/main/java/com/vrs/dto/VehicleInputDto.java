package com.vrs.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/*//For generating Getters , Setters , Constructors etc. 
@Data
//For generating all argument constructors
@AllArgsConstructor
//For generating no argument constructors
@NoArgsConstructor	*/
public class VehicleInputDto {

	// Vehicle Number can not be empty
	@NotEmpty
	// Vehicle Number must be in this pattern [TN 23 AC 1231]
	@Pattern(regexp = "^[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}$", message = "Invaild Vehicle Number. Vehicel number should be in this format(TN 23 CF 1313)")
	private String vehicleNumber;

	// Vehicle type cannot be empty and it should contain only characters
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle type.It should contain only Character")
	private String type;

	// Vehicle category cannot be empty and it should contain only characters
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle Category.It should contain only Character")
	private String category;

	@NotEmpty(message = "Vehicle description cannot be Empty")
	private String description;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle Location.It should contain only Character")
	private String location;

	@NotNull(message = "Capacity cannot be null")
	@Min(2)
	private int capacity;

	@NotNull(message = "Charges per Kilometer cannot be null")
	@Min(10)
	private double chargesPerKM;

	@NotNull(message = "Fixed charges cannot be null")
	@Min(200)
	private double fixedCharges;

	private int driverId;

	private int bookingId;

	public VehicleInputDto(
			@NotEmpty @Pattern(regexp = "^[A-Z]{2}\\s[0-9]{2}\\s[A-Z]{2}\\s[0-9]{4}$", message = "Invaild Vehicle Number. Vehicel number should be in this format(TN 23 CF 1313)") String vehicleNumber,
			@NotEmpty @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle type.It should contain only Character") String type,
			@NotEmpty @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle Category.It should contain only Character") String category,
			@NotEmpty(message = "Vehicle description cannot be Empty") String description,
			@NotEmpty @Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid Vehicle Location.It should contain only Character") String location,
			@NotNull(message = "Capacity cannot be null") @Min(2) int capacity,
			@NotNull(message = "Charges per Kilometer cannot be null") @Min(10) double chargesPerKM,
			@NotNull(message = "Fixed charges cannot be null") @Min(200) double fixedCharges, int driverId,
			int bookingId) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.location = location;
		this.capacity = capacity;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
		this.driverId = driverId;
		this.bookingId = bookingId;
	}

	public VehicleInputDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
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

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "VehicleInputDto [vehicleNumber=" + vehicleNumber + ", type=" + type + ", category=" + category
				+ ", description=" + description + ", location=" + location + ", capacity=" + capacity
				+ ", chargesPerKM=" + chargesPerKM + ", fixedCharges=" + fixedCharges + ", driverId=" + driverId
				+ ", bookingId=" + bookingId + "]";
	}

}
