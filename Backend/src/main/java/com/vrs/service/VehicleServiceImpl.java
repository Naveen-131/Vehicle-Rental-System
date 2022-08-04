package com.vrs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrs.dao.IDriverRepository;
import com.vrs.dao.IVehicleRepository;
import com.vrs.dto.VehicleDto;
import com.vrs.dto.VehicleInputDto;
import com.vrs.entities.Driver;
import com.vrs.entities.Vehicle;
import com.vrs.exception.VehicleNotFoundException;

@Service
public class VehicleServiceImpl implements IVehicleService {

	// Injecting dependency
	@Autowired
	IVehicleRepository vehicleRepository;

	@Autowired
	IDriverRepository driverRepository;

	// Add new vehicle details into database
	@Override
	public Vehicle addVehicle(VehicleInputDto vehicleDto) {
		Vehicle vehicle = new Vehicle();

		Optional<Driver> driver = driverRepository.findById(vehicleDto.getDriverId());
		vehicle.setCapacity(vehicleDto.getCapacity());
		vehicle.setCategory(vehicleDto.getCategory());
		vehicle.setChargesPerKM(vehicleDto.getChargesPerKM());
		vehicle.setDescription(vehicleDto.getDescription());
		vehicle.setFixedCharges(vehicleDto.getFixedCharges());
		vehicle.setLocation(vehicleDto.getLocation());
		vehicle.setType(vehicleDto.getType());
		vehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
		vehicle.setDriver(driver.get());
		vehicleRepository.save(vehicle);
		return vehicle;
	}

	// Update existing vehicle details
	@Override
	public Vehicle updateVehicle(VehicleInputDto vehicleDto, int id) {
		Optional<Vehicle> optional = vehicleRepository.findById(id);

		// Checking vehicle is present or not
		if (!optional.isPresent()) {
			throw new VehicleNotFoundException("No Vehicle is found with given Vehicle Id : " + id);
		} else {

			Vehicle dbVehicle = optional.get();
			dbVehicle.setVehicleNumber(vehicleDto.getVehicleNumber());
			dbVehicle.setType(vehicleDto.getType());
			dbVehicle.setCategory(vehicleDto.getCategory());
			dbVehicle.setDescription(vehicleDto.getDescription());
			dbVehicle.setLocation(vehicleDto.getLocation());
			dbVehicle.setCapacity(vehicleDto.getCapacity());
			dbVehicle.setChargesPerKM(vehicleDto.getChargesPerKM());
			dbVehicle.setFixedCharges(vehicleDto.getFixedCharges());
			/*
			 * 
			 * dbVehicle.setBooking(vehicle.getBooking());
			 */
			vehicleRepository.save(dbVehicle);
			return dbVehicle;
		}
	}

	// Update vehicle location by vehicle ID
	@Override
	public Vehicle updateLocationById(int vehicleId, String location) {
		Optional<Vehicle> optional = vehicleRepository.findById(vehicleId);
		// Checking vehicle is present or not
		if (!optional.isPresent()) {
			throw new VehicleNotFoundException("No Vehicle is found with given Vehicle Id: " + vehicleId);

		} else {
			Vehicle dbVehicle = optional.get();
			dbVehicle.setLocation(location);
			vehicleRepository.save(dbVehicle);
			return dbVehicle;
		}
	}

	// Deleting Vehicle's information from database with a specific id
	@Override
	public Vehicle deleteVehicleById(int vehicleId) {
		Optional<Vehicle> optional = vehicleRepository.findById(vehicleId);
		// Checking vehicle is present or not
		if (!optional.isPresent()) {
			throw new VehicleNotFoundException(
					"There is no existing Vehicle to be deleted with given Vehicle Id: " + vehicleId);
		}
		vehicleRepository.deleteById(vehicleId);
		return optional.get();
	}

	// Retrieving a vehicle's information with a specific id
	@Override
	public Vehicle getVehicleById(int vehicleId) {
		Optional<Vehicle> optional = vehicleRepository.findById(vehicleId);
		if (!optional.isPresent()) {
			throw new VehicleNotFoundException("No Vehicle is found with given Vehicle Id: " + vehicleId);
		}
		return optional.get();
	}

	// Retrieving all the vehicles from database
	@Override
	public List<Vehicle> getAllVehicles() {
		List<Vehicle> vehiclesList = vehicleRepository.findAll();
		if (vehiclesList.isEmpty()) {
			throw new VehicleNotFoundException("No vehicles in the database");
		} else {
			return vehiclesList;
		}

	}

	// Retrieving all the vehicles based on the capacity
	@Override
	public List<Vehicle> getVehiclesByCapacity(int capacity) {
		List<Vehicle> vehiclesList = vehicleRepository.getVehiclesByCapacity(capacity);
		if (vehiclesList.isEmpty()) {
			throw new VehicleNotFoundException("No vehicles available with capacity" + capacity);

		} else {
			return vehiclesList;
		}
	}

	// Retrieving all the vehicles based on the vehicle type
	@Override
	public List<Vehicle> getVehiclesByType(String type) {
		List<Vehicle> vehiclesList = vehicleRepository.getVehiclesByType(type);
		if (vehiclesList.isEmpty()) {
			throw new VehicleNotFoundException("No vehicles available ");

		} else {
			return vehiclesList;
		}
	}

	// Retrieving all the vehicles based on the location
	@Override
	public List<Vehicle> getVehiclesByLocation(String location) {
		List<Vehicle> vehiclesList = vehicleRepository.getVehiclesByLocation(location);
		if (vehiclesList.isEmpty()) {
			throw new VehicleNotFoundException("No vehicles available in that location :" + location);
		} else {
			return vehiclesList;
		}
	}

	// Retrieving all the vehicles based on given price range
	@Override
	public List<Vehicle> getVehiclesByPrice(double min, double max) {

		List<Vehicle> vehiclesList = vehicleRepository.getVehiclesByPrice(min, max);
		if (vehiclesList.isEmpty()) {
			throw new VehicleNotFoundException("No vehicles Availabe in that price range");
		} else {
			return vehiclesList;
		}

	}

	@Override
	public VehicleDto getVehicleDriverInfoById(int vehicleId) {
		Optional<Vehicle> optional = vehicleRepository.findById(vehicleId);
		if (!optional.isPresent()) {
			throw new VehicleNotFoundException("No Vehicle is found with given Vehicle Id: " + vehicleId);
		} else {
			return vehicleRepository.getVehicleDriverInfoById(vehicleId);
		}

	}

	@Override
	public List<VehicleDto> getAllVehiclesDriverInfo() {
		List<VehicleDto> vehiclesList = vehicleRepository.getAllVehicleDriverInfo();
		if (vehiclesList.isEmpty()) {
			throw new VehicleNotFoundException("No vehicles in the database");
		} else {
			return vehiclesList;
		}
	}

}
