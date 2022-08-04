package com.vrs.service;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrs.exception.InvalidIdException;
import com.vrs.controller.UserController;
import com.vrs.dao.IUserRepository;
import com.vrs.dto.UserDTO;
import com.vrs.dto.UserWithPasswordDTO;
//import com.vrs.dto.UserCustomerDto;
import com.vrs.entities.User;
import com.vrs.exception.InvalidCredentialsException;
import com.vrs.exception.UserFoundException;
import com.vrs.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService {
	private static final Logger logger = LogManager.getLogger(UserController.class);
	@Autowired
	IUserRepository userDao;

	@Override
	public User addUser(User user) {
		
		Optional<User> opt = userDao.findById(user.getUserId());
		 if(opt.isPresent()) {
			 throw new UserFoundException("User already exist with given id: "+user.getUserId());
		 }
		 logger.info("successfully entered with user id"+user.getUserId());
		return userDao.save(user);
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> opt = userDao.findById(userId);
		 if(!opt.isPresent()) {
			 throw new UserNotFoundException("User not found with given id: "+userId);
		 }
		 logger.info("successfully found user details by User Id"+userId);
		return userDao.findById(userId).get();
	}

	@Override
	public List<User> getAllUsers() {
		
			List<User> opt = (List<User>) userDao.findAll();
			if (opt.isEmpty()) {
				logger.error("No bookings found");
				throw new UserNotFoundException("Currently No Users");
			}
			else {
			logger.info("Users Found");
			return (List<User>) userDao.findAll();
				}
			}
		

	@Override
	public User removeUserById(int userId) {
		Optional<User> opt = userDao.findById(userId);
		 if(!opt.isPresent()) {
			 throw new UserNotFoundException("User not found with given id: "+userId);
		 }
		 userDao.deleteById(userId);
		 logger.info("successfully deleted user id"+userId);
		 return opt.get();
	}
	
	@Override
	public List<User> getUserByRole(String role) 
	{

		List<User> opt = (List<User>) userDao.getUserByRole(role);
		if(opt.isEmpty())
		{
			throw new UserNotFoundException("Currently No users of given role "+role);
		}
		logger.info("User found of given role "+role);
		return (List<User>) userDao.getUserByRole(role);
    	
	}
	
	@Override
	public User updateDetails(User user) {
		Optional<User> opt = userDao.findById(user.getUserId());
		if(opt.isPresent()) {
			User updateuser = opt.get();
			updateuser.setPassword(user.getPassword());
			updateuser.setRole(user.getRole());
			updateuser.setUserAge(user.getUserAge());
			 userDao.save(updateuser);
			 logger.info("successfully updated with user id: "+user.getUserId());
			 return user;
		}	
		else {
			throw new UserNotFoundException("Error while updating, booking not found with id: " +user.getUserId());
		}
	}
    @Override
	public List<User> getUserByAge(int userAge)
    {
		//List<User> users=userDao.getUserByAge(userAge);
    	List<User> opt = (List<User>) userDao.getUserByAge(userAge);
		if(opt.isEmpty())
		{
			throw new UserNotFoundException("Currently No users of age "+userAge);
		}
		logger.info("User found of age "+userAge);
		return (List<User>) userDao.getUserByAge(userAge);
    	
    	

	}

    /*
	@Override
	public List<UserCustomerDto> getUserCustByRole(String role) {
		List<UserCustomerDto> users=userDao.getUserCustByRole(role);
		logger.info("successfully fetched the list of users of role: "+role);
		return users;
	}
	*/
 // Update User Password
 	@Override
 	public User updateUserPassword(int userId, String password) {
 		Optional<User> optUser = userDao.findById(userId);
 		User u = optUser.get();
 		if (optUser.isPresent()) {
 			u.setPassword(password);
 			userDao.save(u);
 			return u;
 		}
 		else {
 			throw new InvalidIdException("Enter valid user id.");
 		}
 	}
    
 // Sign In
 	@Override
 	public UserDTO signIn(UserWithPasswordDTO userWithPasswordDTO) {
 		Optional<User> optUser= userDao.findByEmail(userWithPasswordDTO.getEmail());
 		UserDTO userDTO = new UserDTO();
 		
 		if(optUser.isPresent()) {
 			User u = optUser.get();
 			
 			if(u.getEmail().equals(userWithPasswordDTO.getEmail()) && u.getRole().equals(userWithPasswordDTO.getRole()) && u.getPassword().equals(userWithPasswordDTO.getPassword()) ) {
 				if(u.isLoggedIn() == false) {
 					u.setLoggedIn(true);
// 					userWithPasswordDTO.setLoggedIn(true);			
 					userDao.save(u);
 				}
 				userDTO.setEmail(u.getEmail());
 				userDTO.setLoggedIn(true);
 				userDTO.setRole(u.getRole());
 				return userDTO;
 			}
 			else {
 				throw new InvalidCredentialsException("Enter valid credentials");
 			}	
 		}
 		else {
 			throw new InvalidCredentialsException("Enter valid credentials");
 		}
 	}

 	// Sign Out
 	@Override
 	public UserDTO signOut(String email) {
 		Optional<User> optUser= userDao.findByEmail(email);
 		User u = optUser.get();
 		UserDTO userDTO = new UserDTO();


 		if(optUser.isPresent()) {
 			if(u.isLoggedIn() == true) {
 				u.setLoggedIn(false);
 				//user.setLoggedIn(false);
 				userDao.save(u);
 			}
 		}
 		
 		userDTO.setEmail(u.getEmail());
 		userDTO.setLoggedIn(false);
 		userDTO.setRole(u.getRole());
 		return userDTO;
 	}
}
