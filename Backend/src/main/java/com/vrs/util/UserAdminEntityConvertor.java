package com.vrs.util;

import org.springframework.stereotype.Component;

import com.vrs.dto.*;
import com.vrs.entities.*;

@Component
public class UserAdminEntityConvertor {
		//Conversion from UserWithPasswordDTO to User
		public User convertUserPasswordDtoToUser(UserWithPasswordDTO userPasswordDTO){
			User user = new User();
			user.setPassword(userPasswordDTO.getPassword());
			user.setRole(userPasswordDTO.getRole());
			user.setEmail(userPasswordDTO.getEmail());
			user.setUserId(userPasswordDTO.getUserId());
			return user;
		}
		
		//Conversion from UserWithPasswordDTO to UserDTO
		public UserDTO convertToUserDTO(UserWithPasswordDTO userPasswordDTO){
			UserDTO userDTO = new UserDTO();
			userDTO.setRole(userPasswordDTO.getRole());
			userDTO.setEmail(userPasswordDTO.getEmail());
			userDTO.setUserId(userPasswordDTO.getUserId());
			//userDTO.setLoggedIn(userPasswordDTO.get);
			return userDTO;
		}
}
