package com.vrs.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.vrs.dto.*;
import com.vrs.entities.*;

@Component
public class UserAdminDTOEntityConverter {
	
	//Conversion from AdminDTO to Admin
	public Admin convertToAdminEntity(AdminDTO adminDTO){
		Admin admin = new Admin();
		admin.setAdminContact(adminDTO.getAdminContact());
		admin.setAdminId(adminDTO.getAdminId());
		admin.setAdminName(adminDTO.getAdminName());
		return admin;
	}
	
	//Conversion from UserDTO to User
	public User convertToUserEntity(UserDTO userDTO) {
		User user = new User();
		user.setLoggedIn(userDTO.isLoggedIn());
		user.setRole(userDTO.getRole());
		user.setEmail(userDTO.getEmail());
		//user.setUserId(userDTO.getUserId());
		return user;
	}

}
