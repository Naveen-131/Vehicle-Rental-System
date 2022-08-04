package com.vrs.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;*/

/*//For no argument constructor ,getters and setters
@Data
//For all argument constructor
@AllArgsConstructor
@NoArgsConstructor*/

public class DriverDto {

	// Validating first name
	@Size(min = 2, message = "driver's first name should have atleast 2 characters")
	@Pattern(regexp = "^[a-zA-Z\\\\s]{2,}$", message = "Please enter valid First Name")
	private String firstName;
	// Validating last name
	@NotEmpty(message = "Last name cannot be empty")
	@Pattern(regexp = "^[a-zA-Z\\\\s]{1,}$", message = "Please enter valid Last Name")
	private String lastName;
	// Validating Indian contact numbers
	@NotEmpty(message = "Contact number cannot be empty")
	@Pattern(regexp = "^[+]?[0]?(91)?[789][\\d]{9}$", message = "Please enter valid contact number")
	private String contactNumber;
	// validating price
	@Positive(message = "price should be positive")
	private double chargesPerDay;
	@NotEmpty
	private String vehicleNumber;
	@NotEmpty
	private String type;// car//bus
	@NotEmpty
	private String category; // ac or nonac
	private String description;
	@NotEmpty
	private double chargesPerKM;
	@NotEmpty
	private double fixedCharges;

	public DriverDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverDto(
			@Size(min = 2, message = "driver's first name should have atleast 2 characters") @Pattern(regexp = "^[a-zA-Z\\\\s]{2,}$", message = "Please enter valid First Name") String firstName,
			@NotEmpty(message = "Last name cannot be empty") @Pattern(regexp = "^[a-zA-Z\\\\s]{1,}$", message = "Please enter valid Last Name") String lastName,
			@NotEmpty(message = "Contact number cannot be empty") @Pattern(regexp = "^[+]?[0]?(91)?[789][\\d]{9}$", message = "Please enter valid contact number") String contactNumber,
			@Positive(message = "price should be positive") double chargesPerDay, @NotEmpty String vehicleNumber,
			@NotEmpty String type, @NotEmpty String category, String description, @NotEmpty double chargesPerKM,
			@NotEmpty double fixedCharges) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.chargesPerDay = chargesPerDay;
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		this.category = category;
		this.description = description;
		this.chargesPerKM = chargesPerKM;
		this.fixedCharges = fixedCharges;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getChargesPerDay() {
		return chargesPerDay;
	}

	public void setChargesPerDay(double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
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
		return "DriverDto [firstName=" + firstName + ", lastName=" + lastName + ", contactNumber=" + contactNumber
				+ ", chargesPerDay=" + chargesPerDay + ", vehicleNumber=" + vehicleNumber + ", type=" + type
				+ ", category=" + category + ", description=" + description + ", chargesPerKM=" + chargesPerKM
				+ ", fixedCharges=" + fixedCharges + "]";
	}

}
