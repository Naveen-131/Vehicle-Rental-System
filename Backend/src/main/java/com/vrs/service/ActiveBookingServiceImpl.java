package com.vrs.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrs.dao.IActiveBookingRepository;
import com.vrs.dto.ActiveBookingDto1;
import com.vrs.dto.ActiveBookingDto2;
import com.vrs.entities.ActiveBooking;
import com.vrs.exception.ActiveBookingDuplicateValueException;
import com.vrs.exception.ActiveBookingInvalidInputException;
import com.vrs.exception.ActiveBookingNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class ActiveBookingServiceImpl implements IActiveBookingService {

	private static final Logger logger = LogManager.getLogger(ActiveBookingServiceImpl.class);

	@Autowired
	IActiveBookingRepository activeBookingDao;

	//to view all active booking
	@Override
	public List<ActiveBooking> viewAllActiveBooking() {
		return activeBookingDao.findAll();
	}
	
	//to add Active booking
    @Override
	public ActiveBooking addActiveBooking(ActiveBooking activeBooking) {
		Optional<ActiveBooking> opt = activeBookingDao.findById(activeBooking.getActiveBookingId());
		if (opt.isPresent()) {
			logger.info("ActiveBookingDuplicateValue Exception occured-ActiveBooking Id is already there ");

			throw new ActiveBookingDuplicateValueException("ActiveBooking Id is already there");

		}

		if (!(Pattern.matches("^[a-zA-Z\\s]{2,}", activeBooking.getStatus()))) {
			logger.info("ActiveBookingInvalidInputException occured-Enter a valid Status ");
			throw new ActiveBookingInvalidInputException("Enter a valid Status");
		}

		return activeBookingDao.save(activeBooking);
	}

    //to get active booking by id
	@Override
	public ActiveBooking getActiveBookingById(int activeBookingId) {
		Optional<ActiveBooking> opt = activeBookingDao.findById(activeBookingId);
		if (!opt.isPresent()) {
			logger.info(
					"ActiveBookingNotFoundException Occured-Booking Id not found,Process done in getActiveBookingById");
			throw new ActiveBookingNotFoundException("Booking Id " + activeBookingId + " not found");
		}

		return opt.get();
	}

	//to delete active booking by id
	@Override
	public ActiveBooking deleteActiveBookingbyId(int activeBookingId) {
		Optional<ActiveBooking> opt = activeBookingDao.findById(activeBookingId);
		if (!opt.isPresent()) {
			logger.info(
					"ActiveBookingNotFoundException Occured-Booking Id not found,Process done in deleteActiveBookingById ");
			throw new ActiveBookingNotFoundException("Booking Id " + activeBookingId + " not found");
		}
		activeBookingDao.deleteById(activeBookingId);
		return opt.get();
	}

	//to find active booking by status
	@Override
	public List<ActiveBooking> findByStatus(String status) {
		Optional<List<ActiveBooking>> opt = Optional.of(activeBookingDao.findByStatus(status));

		if (!(opt.isPresent())) {
			logger.info("ActiveBooking Not Found Exception Occured-Booking Status not found,Process done in findByStatus ");
			throw new ActiveBookingNotFoundException("Booking status " + status + " not found");
		}
		return opt.get();
	}

	//to update active booking
	@Override
	public ActiveBooking updateActiveBooking(ActiveBooking activeBooking) {
		Optional<ActiveBooking> opt = activeBookingDao.findById(activeBooking.getActiveBookingId());

		if (!(opt.isPresent())) {
			logger.info("ActiveBookingNotFoundException Occured-Booking Id not found ");
			throw new ActiveBookingNotFoundException("Booking Id not found");

		} else {
			ActiveBooking ac = opt.get();

			if (!(Pattern.matches("^[a-zA-Z\\s]{2,}", activeBooking.getStatus()))) {
				logger.info("ActiveBookingInvalidInputException Occured-Enter a valid Status ");
				throw new ActiveBookingInvalidInputException("Enter a valid Status");
			} else {

				ac.setStatus(activeBooking.getStatus());
				activeBookingDao.save(ac);
				return ac;
			}

		}

	}

	//to find by pending
	@Override
	public List<ActiveBooking> findByPending() {
		List<ActiveBooking> pendingList = activeBookingDao.findByPending();
		if (pendingList.isEmpty()) {
			logger.info("ActiveBookingNotFoundException Occured-Pending list is Empty ");
			throw new ActiveBookingNotFoundException("Pending list is Empty");
		}

		return pendingList;
	}

	//to find by inprogress
	@Override
	public List<ActiveBooking> findByInprogress() {
		List<ActiveBooking> inprogressList = activeBookingDao.findByInprogress();
		if (inprogressList.isEmpty()) {
			logger.info("ActiveBookingNotFoundException Occured-InProgress list is Empty");
			throw new ActiveBookingNotFoundException("InProgress list is Empty");
		}

		return inprogressList;
	}

	//to find by cancelled
	@Override
	public List<ActiveBooking> findByCancelled() {
		List<ActiveBooking> cancelledList = activeBookingDao.findByCancelled();
		if (cancelledList.isEmpty()) {
			logger.info("ActiveBookingNotFoundException Occured-Cancelled list is Empty ");
			throw new ActiveBookingNotFoundException("Cancelled list is Empty");
		}

		return cancelledList;
	}

	//to find by completed
	@Override
	public List<ActiveBooking> findByCompleted() {
		List<ActiveBooking> completedList = activeBookingDao.findByCompleted();
		if (completedList.isEmpty()) {
			logger.info("ActiveBookingNotFoundException Occured-Completed list is Empty ");
			throw new ActiveBookingNotFoundException("Completed list is Empty");
		}

		return completedList;
	}

	// to to get bookingDescription by activeBookingId
	@Override
	public ActiveBookingDto1 getBookingDescriptionByActiveBookingId(int activeBookingId) {
		ActiveBookingDto1 opt = activeBookingDao.getBookingDescriptionByActiveBookingId(activeBookingId);
		if (opt == null) {
			logger.info("ActiveBookingNotFoundException Occured-Booking Id not found ");
			throw new ActiveBookingNotFoundException("Booking Id not found");

		}
		return opt;
	}

	// to get totalCost by activeBookingId
	@Override
	public ActiveBookingDto2 getTotalCostByActiveBookingId(int activeBookingId) {

		ActiveBookingDto2 opt = activeBookingDao.getTotalCostByActiveBookingId(activeBookingId);
		if (opt == null) {
			logger.info("ActiveBookingNotFoundException Occured-Booking Id not found ");
			throw new ActiveBookingNotFoundException("Booking Id not found");

		}
		return opt;
	}

}
