package com.vrs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrs.dao.IAdminRepository;
import com.vrs.entities.Admin;
import com.vrs.exception.AdminNotFoundException;
import com.vrs.exception.InvalidIdException;



@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository adminRepository;
	
	//Add New Admin
	@Override
	public Admin addNewAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	// Update Admin
	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> optAdmin= adminRepository.findById(admin.getAdminId());
		
		if(optAdmin.isPresent()) {
			Admin a = optAdmin.get();
			a.setAdminContact(admin.getAdminContact());
			a.setAdminId(admin.getAdminId());
			a.setAdminName(admin.getAdminName());
			adminRepository.save(a);
		}
		
		return admin;		
	}

	// Delete Admin
	@Override
	public Admin deleteAdmin(int adminId) {
		Optional<Admin> optAdmin = adminRepository.findById(adminId);
		if(optAdmin.isPresent()) {
			adminRepository.deleteById(adminId);
			return optAdmin.get();
		}
		else {
			throw new InvalidIdException("Enter valid admin id.");
		}
	}
	
	// All Admins
	@Override
	public List<Admin> viewAllAdmins() {
		return (List<Admin>) adminRepository.findAll();
	}
	
	// View Admin By Id
	@Override
	public Admin viewAdminById(int adminId) {
		Optional<Admin> adminOpt = adminRepository.findById(adminId);
		if(!adminOpt.isPresent()) {
			throw new AdminNotFoundException("Admin not found with given Id"+adminId);
		} else {
			return adminOpt.get();
		}

	}
	
	// Update Admin Contact Number
	@Override
	public Admin updateAdminContactNumber(int adminId, String contactNumber) {
		Optional<Admin> optAdmin = adminRepository.findById(adminId);
		Admin a = optAdmin.get();
		if (optAdmin.isPresent()) {
			a.setAdminContact(contactNumber);;
			adminRepository.save(a);			
			return a;
		}
		else {
			throw new InvalidIdException("Enter valid admin id.");
		}
	}

}
