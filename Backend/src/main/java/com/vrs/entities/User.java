package com.vrs.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


//@AllArgsConstructor
//@Data
@Entity
@Table(name="user_all")
public class User 
{

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", userAge=" + userAge
				+ ", customer=" + customer + "]";
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getUserAge() {
		return userAge;
	}


	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}


	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public User(int userId, @NotNull @Size(min = 4, max = 15) 
	String password,@NotNull 
	@Size(min = 1, max = 35)
	@Pattern(regexp = "^[a-zA-Z]{1,35}$", message = "invalid role") String role,int userAge, Customer customer) 
	{
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.userAge = userAge;
		this.customer = customer;
	}
	
	public User(int userId, @NotNull @Size(min = 4, max = 15) 
	String password,@NotNull 
	@Size(min = 1, max = 35)
	@Pattern(regexp = "^[a-zA-Z]{1,35}$", message = "invalid role") String role,int userAge) 
	{
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.userAge = userAge;
	}


	//fields
	//assume userId as primary key.
	@Id	
	//@GeneratedValue
	//@NotNull
	//@Size(min=3,message="user id should have atleast 3 char")
	private int userId;
	
	@NotNull
	@Size(min = 4,max = 15)
	//@Pattern(regexp="^[a-zA-Z][0-9]{1,15}$", message = "password invalid")
	private String password;
	
	@NotNull
	
	@Size(min=1,max=35)
	@Pattern(regexp="^[a-zA-Z]{1,35}$",message="invalid role")
	private String role;
	
	
	private int userAge;
	
	/*@JsonIgnore
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="customer_id_fk")
	private Customer customer;*/
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id_fk")
	private Customer customer;

	@JsonIgnore
	@Column(name="isLoggedIn")
	private boolean isLoggedIn = false;
	
	@NotNull(message = "User email should not be empty.")
	@Column(name = "user_email")
	private String email;
	
	@JsonIgnore
	@OneToOne(targetEntity = Admin.class, cascade = CascadeType.ALL)
	private Admin admin;
	
	public User(){}

	

}
	
	