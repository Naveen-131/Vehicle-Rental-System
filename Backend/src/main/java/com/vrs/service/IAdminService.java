package com.vrs.service;

import java.util.List;

import com.vrs.entities.Admin;


public interface IAdminService {
	
	//Add New Admin
	public Admin addNewAdmin(Admin admin);
		
	// Update Admin
	public Admin updateAdmin(Admin admin);
		
	// Update Admin Contact Number
	public Admin updateAdminContactNumber(int adminId, String  contactNumber);
		
	// Delete Admin
	public Admin deleteAdmin(int adminId);
		
	// View Admin By Id
	public Admin viewAdminById(int adminId);
		
	// All Admins
	public List<Admin> viewAllAdmins();
}
