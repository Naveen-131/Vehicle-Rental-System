package com.vrs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrs.entities.Admin;
import com.vrs.service.IAdminService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AdminController {
	@Autowired
	IAdminService adminService; 
	
	//View all admin
	@GetMapping("/admin/all")
	public ResponseEntity<List<Admin>> getAllAdmins()	{
		return new ResponseEntity<>(adminService.viewAllAdmins(), HttpStatus.OK);

	}
	
	//Add Admin
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.addNewAdmin(admin), HttpStatus.OK);
	}
	
	//Update admin
	@PutMapping("/admin/update")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<>(adminService.updateAdmin(admin), HttpStatus.OK);

	}
	
	//Admin by Id
	@GetMapping("/admin/{adminId}")
	public ResponseEntity<Admin> viewAdminById(@PathVariable("adminId") int adminId) {
		return new ResponseEntity<>(adminService.viewAdminById(adminId), HttpStatus.OK);

	}
	
	//Delete Admin by Id
	@DeleteMapping("/admin/{adminId}")
	public ResponseEntity<Admin> deleteAdminById(@PathVariable("adminId") int adminId) {
		return new ResponseEntity<>(adminService.deleteAdmin(adminId), HttpStatus.OK);
	}
	
	//Update Admin Contact Number
	@PatchMapping("/admin/{adminId}")
	public ResponseEntity<Admin> updateAdminContactNumber(@PathVariable("adminId") int adminId, @RequestBody String contactNumber) {
		return new ResponseEntity<>(adminService.updateAdminContactNumber(adminId, contactNumber), HttpStatus.OK);

	}
}

