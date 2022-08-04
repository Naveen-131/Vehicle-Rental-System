package com.vrs.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.vrs.dto.UserCustomerDto;
import com.vrs.entities.User;


@Repository
public interface IUserRepository extends JpaRepository<User,Integer>
{
	@Query("select u from User u where u.role=:role")
	List<User> getUserByRole(@Param("role") String role);	
	
	@Query("select u from User u where u.userAge =:userAge")
	List<User> getUserByAge(@Param("userAge") int userAge);	
		
	Optional<User> findByEmail(String email);
	/*
	@Query("select new com.vrs.dto.UserCustomerDto(u.userId, c.firstName, c.lastName, c.mobileNumber, u.role) from user u inner join customer c on u.customer_id_fk=c.customerId where u.role=:role")
	List<UserCustomerDto> getUserCustByRole(@Param("role") String role);
	*/
}



