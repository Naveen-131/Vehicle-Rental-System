package com.vrs.controller;



import java.util.ArrayList;
import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrs.util.UserAdminDTOEntityConverter;
import com.vrs.util.UserAdminEntityConvertor;
import com.vrs.util.UserAdminEntityDTOConverter;
import com.vrs.dto.UserWithPasswordDTO;
import com.vrs.dto.UserDTO;
import com.vrs.entities.User;
import com.vrs.service.IUserService;

@Validated
@RestController

@CrossOrigin(origins="http://localhost:3000")
public class UserController {
	//private static final Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	IUserService userServ;
		
	@Autowired
	UserAdminDTOEntityConverter dtoEntityConverter;
	
	@Autowired
	UserAdminEntityDTOConverter entityDtoConverter;
	
	@Autowired
	UserAdminEntityConvertor entityConverter;
	//Add user - Post
	@PostMapping("/user/add")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserWithPasswordDTO userWithPasswordDTO) {
		User user = entityConverter.convertUserPasswordDtoToUser(userWithPasswordDTO);
		User updatedUser = userServ.addUser(user);
		UserDTO userDTO = entityDtoConverter.convertToUserDTO(updatedUser);
		return new ResponseEntity<>(userDTO,HttpStatus.OK);
		
	}
				
	//Getting all users - Get
	    @GetMapping("/user/all")
	    public ResponseEntity<List<UserDTO>> getAllUsers() {
	    	List<User> users = userServ.getAllUsers();
			List<UserDTO> userDTOs = new ArrayList<>();
			
			for(User u: users) {
				UserDTO userDTO = entityDtoConverter.convertToUserDTO(u);
				userDTOs.add(userDTO);
			}
			
			return new ResponseEntity<>(userDTOs,HttpStatus.OK);
		}
	    
   //Get users based on userId - Get
	    @GetMapping("/user/{userId}")
		public ResponseEntity<UserDTO> viewUserById(@PathVariable("userId")int userId) {
			User user = userServ.getUserById(userId);
			
			UserDTO userDTO = entityDtoConverter.convertToUserDTO(user);
			return new ResponseEntity<>(userDTO,HttpStatus.OK);
		}
	    
	  	
	 //Delete users based on userId - Delete
	    @DeleteMapping("/user/{userId}")
		public ResponseEntity<UserDTO> deleteUserById(@PathVariable("userId")int userId) {
			User updatedUser = userServ.removeUserById(userId);		
			UserDTO userDTO = entityDtoConverter.convertToUserDTO(updatedUser);
			return new ResponseEntity<>(userDTO,HttpStatus.OK);	
		}		
		
	//Get users based on role - Get
	  	@GetMapping("/users/byRole/{role}")
	  	public ResponseEntity<List<User>> getUserByRole(@PathVariable("role") String role) {
	  	return new ResponseEntity<>(userServ.getUserByRole(role),HttpStatus.OK);//200 Ok
	  	
	  	}
	  	
	 // update user details
	  	@PutMapping("/user/update")
		public ResponseEntity<UserDTO> updateUser(@RequestBody UserWithPasswordDTO userWithPasswordDTO) {
			User user = entityConverter.convertUserPasswordDtoToUser(userWithPasswordDTO);
			User updatedUser = userServ.updateDetails(user);
			
			UserDTO userDTO = entityDtoConverter.convertToUserDTO(updatedUser);
			return new ResponseEntity<>(userDTO,HttpStatus.OK);
		}
	  	
	  //Get users based on Age - Get
	  	@GetMapping("/users/byAge/{userAge}")
	  	public ResponseEntity<List<User>> getUserByAge(@PathVariable("userAge") int userAge) {
	  	return new ResponseEntity<>(userServ.getUserByAge(userAge),HttpStatus.OK);//200 Ok
	  	
	  	}
		
	  //Update User Password
		@PatchMapping("/user/{userId}")
		public ResponseEntity<UserDTO> updateUserPassword(@PathVariable("userId")int UserId, @RequestBody String password) {
			User user = userServ.updateUserPassword(UserId, password);
			
			UserDTO userDTO = entityDtoConverter.convertToUserDTO(user);
			return new ResponseEntity<>(userDTO,HttpStatus.OK);		
			
		}
		
		// Sign In
		@PostMapping("/signin")
		public ResponseEntity<UserDTO> signIn(@RequestBody UserWithPasswordDTO userWithPasswordDTO) {
			//User user = entityConverter.convertUserPasswordDtoToUser(userWithPasswordDTO);
			UserDTO userDTO = userServ.signIn(userWithPasswordDTO);
			
			//UserDTO userDTO = entityDtoConverter.convertToUserDTO(updatedUser);
			return new ResponseEntity<>(userDTO,HttpStatus.OK);	
		}
		
		// Sign Out
		@GetMapping("/signout/{email}")
		public ResponseEntity<UserDTO> signOut(@PathVariable("email") String email) {
			
			UserDTO userDTO = userServ.signOut(email);
			return new ResponseEntity<>(userDTO,HttpStatus.OK);	
		}
	  	/*
	  //Get users based on dto class - Get
		@GetMapping("/users/byUserCustRole/{role}")
		public ResponseEntity<List<UserCustomerDto>> getUserCustByRole(@PathVariable("role") String role) {
		return new ResponseEntity<>(userServ.getUserCustByRole(role),HttpStatus.OK);//200 Ok
		  	
		  	}	*/
		  
	  
	  	
	  	
}
	  	