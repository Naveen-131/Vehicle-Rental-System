package com.vrs.dto;



public class UserWithPasswordDTO {
		// Fields
		private int userId;
		private String email;
		private String role;
		private String password;
		
		// Constructors
		public UserWithPasswordDTO() {
			
		}
		
		public UserWithPasswordDTO(String email,String password,String role,int userId) {
			this.password = password;
			this.role = role;
			this.email = email;
			this.userId=userId;
		}

		// Getter and Setter
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		// ToString
		@Override
		public String toString() {
			return "UserWithPasswordDTO [email=" + email + ", role=" + role + ", password=" + password + "]";
		}

		
}
