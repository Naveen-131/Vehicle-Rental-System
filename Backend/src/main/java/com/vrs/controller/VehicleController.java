package com.vrs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrs.dto.VehicleDto;
import com.vrs.dto.VehicleInputDto;
import com.vrs.entities.Vehicle;
import com.vrs.service.IVehicleService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class VehicleController {

	@Autowired
	IVehicleService vehicleService;

	// Method for adding new vehicle object in the database
	@PostMapping("/vehicle/")
	public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody VehicleInputDto vehicle) {
		return new ResponseEntity<>(vehicleService.addVehicle(vehicle), HttpStatus.OK);
	}

	// Method for updating already existing vehicle object present in the database
	@PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@Valid @RequestBody VehicleInputDto vehicle,
			@PathVariable("id") int id) {
		return new ResponseEntity<>(vehicleService.updateVehicle(vehicle, id), HttpStatus.OK);
	}

	// Method for returning vehicle object with vehicle id same as that passed in
	// url
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int vehicleId) {
		return new ResponseEntity<>(vehicleService.getVehicleById(vehicleId), HttpStatus.OK);

	}

	// Method for returning all the vehicle objects present in the database
	@GetMapping("/vehicle/all")
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
	}

	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> deleteVehicleById(@PathVariable("id") int vehicleId) {
		return new ResponseEntity<>(vehicleService.deleteVehicleById(vehicleId), HttpStatus.OK);
	}

	// Method for updating vehicle location
	@PatchMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> updateLocationById(@Valid @PathVariable("id") int vehicleId,
			@RequestBody String location) {
		return new ResponseEntity<>(vehicleService.updateLocationById(vehicleId, location), HttpStatus.OK);
	}

	// Method for getting all the vehicles based on capacity
	@GetMapping("vehicle/capacity/{c}")
	public ResponseEntity<List<Vehicle>> getVehiclesByCapacity(@PathVariable("c") int capacity) {
		return new ResponseEntity<>(vehicleService.getVehiclesByCapacity(capacity), HttpStatus.OK);
	}

	// Method for getting all the vehicles based on vehicle type
	@GetMapping("vehicle/type/{type}")
	public ResponseEntity<List<Vehicle>> getVehiclesByType(@PathVariable("type") String type) {
		return new ResponseEntity<>(vehicleService.getVehiclesByType(type), HttpStatus.OK);
	}

	// Method for getting all the vehicles from a specific location
	@GetMapping("vehicle/location/{location}")
	public ResponseEntity<List<Vehicle>> getVehiclesByLocation(@PathVariable("location") String location) {
		return new ResponseEntity<>(vehicleService.getVehiclesByLocation(location), HttpStatus.OK);
	}

	// Method for getting all the vehicles based on given price range
	@GetMapping("vehicle/price/{min}/{max}")
	public ResponseEntity<List<Vehicle>> getVehiclesByPrice(@PathVariable("min") double min,
			@PathVariable("max") double max) {
		return new ResponseEntity<>(vehicleService.getVehiclesByPrice(min, max), HttpStatus.OK);
	}

	@GetMapping("/vehicle/driver/{id}")
	public ResponseEntity<VehicleDto> getVehicleDriverById(@PathVariable("id") int vehicleId) {
		return new ResponseEntity<>(vehicleService.getVehicleDriverInfoById(vehicleId), HttpStatus.OK);
	}

	@GetMapping("/vehicle/driver/all")
	public ResponseEntity<List<VehicleDto>> getAllVehicleDriverInfo() {
		return new ResponseEntity<>(vehicleService.getAllVehiclesDriverInfo(), HttpStatus.OK);
	}

}