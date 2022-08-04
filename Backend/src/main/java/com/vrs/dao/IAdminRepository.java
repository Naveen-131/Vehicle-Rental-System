package com.vrs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrs.entities.Admin;


public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
