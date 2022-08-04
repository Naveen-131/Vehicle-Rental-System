package com.vrs.util;


import org.springframework.stereotype.Component;

import com.vrs.dto.*;
import com.vrs.entities.*;

@Component
public class UserAdminEntityDTOConverter {

		//Conversion from Admin to AdminDTO
		public AdminDTO convertToAdminDTO(Admin admin){
			AdminDTO adminDTO = new AdminDTO();
			adminDTO.setAdminContact(admin.getAdminContact());
			adminDTO.setAdminId(admin.getAdminId());
			adminDTO.setAdminName(admin.getAdminName());
			return adminDTO;
		}
		
		//Conversion from User to UserDTO
		public UserDTO convertToUserDTO(User user) {
			UserDTO userDTO = new UserDTO();
			userDTO.setLoggedIn(user.isLoggedIn());
			userDTO.setRole(user.getRole());
			userDTO.setEmail(user.getEmail());
			userDTO.setUserId(user.getUserId());
			return userDTO;
		}


}
