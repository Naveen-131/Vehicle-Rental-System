package com.vrs.service;

import java.util.List;

import com.vrs.dto.VehicleDto;
import com.vrs.dto.VehicleInputDto;
import com.vrs.entities.Vehicle;

public interface IVehicleService {

	// Add Vehicle
	Vehicle addVehicle(VehicleInputDto vehicle);

	// Update existing vehicle details
	Vehicle updateVehicle(VehicleInputDto vehicle, int id);

	// Update vehicle location by vehicle ID
	Vehicle updateLocationById(int vehicleId, String location);

	// Delete vehicle details by vehicle ID
	Vehicle deleteVehicleById(int vehicleId);

	// Get Vehicle details by ID
	Vehicle getVehicleById(int vehicleId);

	// Get all vehicle details
	List<Vehicle> getAllVehicles();

	// Get all vehicles based on capacity
	List<Vehicle> getVehiclesByCapacity(int capacity);

	// Get all vehicles based on type
	List<Vehicle> getVehiclesByType(String type);

	// Get all vehicles based on given price range
	List<Vehicle> getVehiclesByPrice(double min, double max);

	// Get all vehicles based on specific location
	List<Vehicle> getVehiclesByLocation(String location);

	// Get Vehicle and Driver details by Vehicle Id
	VehicleDto getVehicleDriverInfoById(int vehicleId);

	// Get All Vehicle along with driver details
	List<VehicleDto> getAllVehiclesDriverInfo();

}
