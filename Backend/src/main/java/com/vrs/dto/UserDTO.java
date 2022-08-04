package com.vrs.dto;


public class UserDTO {

	// Fields
	private int userId;
	private String email;
	private String role;
	private boolean isLoggedIn = false;

	// Constructors
	public UserDTO() {}
	
	public UserDTO(String email,String role, boolean isLoggedIn,int userId) {
		this.email = email;
		this.role = role;
		this.isLoggedIn = isLoggedIn;
		this.userId=userId;
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// Getter and Setter
	public String getRole() {
		return role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}



	// ToString
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", role=" + role + ", isLoggedIn=" + isLoggedIn + "]";
	}
	

}
