package com.vrs.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vrs.dto.ActiveBookingDto1;
import com.vrs.dto.ActiveBookingDto2;
import com.vrs.entities.ActiveBooking;

@Repository
public interface IActiveBookingRepository extends JpaRepository<ActiveBooking, Integer> {

	@Query("select ab from ActiveBooking ab where ab.status=?1")
	List<ActiveBooking> findByStatus(String status);

	@Query("select ab from ActiveBooking ab where ab.status='pending' or  ab.status='Pending' or ab.status= 'PENDING'")
	List<ActiveBooking> findByPending();

	@Query("select ab from ActiveBooking ab where ab.status='inprogress' or  ab.status='Inprogress' or ab.status='INPROGRESS'")
	List<ActiveBooking> findByInprogress();

	@Query("select ab from ActiveBooking ab where ab.status='cancelled' or ab.status='Cancelled' or ab.status='CANCELLED'")
	List<ActiveBooking> findByCancelled();

	@Query("select ab from ActiveBooking ab where ab.status='completed' or ab.status='Completed' or ab.status='COMPLETED'")
	List<ActiveBooking> findByCompleted();

	// to fetch bookingDescription by activeBookingId
	@Query("SELECT new com.vrs.dto.ActiveBookingDto1(a.activeBookingId, a.status,b.bookingDescription)FROM ActiveBooking a inner join Booking b  ON a.booking.bookingId=b.bookingId where a.activeBookingId=:active_id")
	ActiveBookingDto1 getBookingDescriptionByActiveBookingId(@Param("active_id") int activeBookingId);

	// to fetch totalCost by activeBookingId
	@Query("SELECT new com.vrs.dto.ActiveBookingDto2(a.activeBookingId, a.status,b.totalCost) FROM ActiveBooking a inner join Booking b ON a.booking.bookingId=b.bookingId where a.activeBookingId=:active_id")
	ActiveBookingDto2 getTotalCostByActiveBookingId(@Param("active_id") int activeBookingId);

}
