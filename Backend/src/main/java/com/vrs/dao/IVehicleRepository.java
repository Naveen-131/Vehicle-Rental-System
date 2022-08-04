package com.vrs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vrs.dto.VehicleDto;
import com.vrs.entities.Vehicle;

@Repository
public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

	// Get all vehicles based on capacity
	@Query("SELECT v FROM Vehicle v WHERE v.capacity=:capacity")
	List<Vehicle> getVehiclesByCapacity(@Param("capacity") int capacity);

	// Get all vehicles based on type
	@Query("SELECT v FROM Vehicle v WHERE v.type=:type")
	List<Vehicle> getVehiclesByType(@Param("type") String type);

	// Get all vehicles based on given price range
	@Query("SELECT v FROM Vehicle v WHERE v.fixedCharges>=:min AND v.fixedCharges<=:max")
	List<Vehicle> getVehiclesByPrice(@Param("min") double min, @Param("max") double max);

	// Get all vehicles from a specific location
	@Query("SELECT v FROM Vehicle v WHERE v.location like %:location% ")
	List<Vehicle> getVehiclesByLocation(@Param("location") String location);

	// Get Vehicle and Driver information by vehicle ID

	@Query("SELECT new com.vrs.dto.VehicleDto(v.vehicleId,v.vehicleNumber,v.type,v.location,v.chargesPerKM,"
			+ "d.driverId,d.firstName,d.contactNumber,d.licenseNo) "
			+ "FROM Vehicle v inner join Driver d on v.vehicleId=:vehilceId")
	VehicleDto getVehicleDriverInfoById(@Param("vehilceId") int vehicleId);

	// Get all Vehicles along with driver information

	@Query("SELECT new com.vrs.dto.VehicleDto(v.vehicleId,v.vehicleNumber,v.type,v.location,v.chargesPerKM,"
			+ "d.driverId,d.firstName,d.contactNumber,d.licenseNo) "
			+ "FROM Vehicle v inner join Driver d on v.driver.driverId=d.driverId")
	List<VehicleDto> getAllVehicleDriverInfo();

	/*
	 * // Get all vehicle details and driver details by booking id
	 * 
	 * @Query("SELECT VehicleBookingDto(b.bookingId,b.bookingDate,b.bookedTillDate,b.totalCost"
	 * + "v.vehicleId,v.vehicleNumber,v.location" +
	 * "d.driverId,d.firstName,d.contactNumber)" +
	 * "FROM Booking b JOIN Vehicle v ON b.bookingId=v.booking.bookingId" +
	 * "JOIN Driver d ON v.driver.driverId=d.driverId" + "WHERE b.bookingId=?1")
	 * List<VehicleBookingDto> getVehicleDriverByBookingId(int bookingId);
	 */

}