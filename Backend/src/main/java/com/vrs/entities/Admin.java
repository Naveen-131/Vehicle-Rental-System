package com.vrs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;




import javax.persistence.CascadeType;
import javax.persistence.Column;


@Entity
@Table(name="admin")

public class Admin {
	
	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@NotNull(message = "Admin name should not be empty.")
	@Column(name = "admin_name")
	private String adminName;
	
	@NotNull(message = "Admin contact should not be empty.")
	@Column(name = "admin_contact")
	private String adminContact;
	

	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	private User user;


	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admin(int adminId, @NotNull(message = "Admin name should not be empty.") String adminName,
			@NotNull(message = "Admin contact should not be empty.") String adminContact, User user) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.user = user;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	public String getAdminContact() {
		return adminContact;
	}


	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact + ", user="
				+ user + "]";
	}
	
	
	
	

}
