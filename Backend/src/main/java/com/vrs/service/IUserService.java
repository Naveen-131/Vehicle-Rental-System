package com.vrs.service;

import java.util.List;

import com.vrs.dto.UserDTO;
import com.vrs.dto.UserWithPasswordDTO;
//import com.vrs.dto.UserCustomerDto;
import com.vrs.entities.User;


public interface IUserService {
	

	public User addUser(User user);
	public List<User> getAllUsers(); 
	public User getUserById(int userId);
	public User removeUserById(int userId);
	public List<User> getUserByRole(String role);
	public User updateDetails(User user);
	public List<User> getUserByAge(int userAge);
	//public List<UserCustomerDto> getUserCustByRole(String role);
	
	// Sign In
	public UserDTO signIn(UserWithPasswordDTO userWithPasswordDTO);
		
	// Sign Out
	public UserDTO signOut(String email);
	
	public User updateUserPassword(int userId, String password);
}
