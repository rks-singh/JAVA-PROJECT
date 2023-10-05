package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ravi.entitymodel.UserLogin;

import jakarta.transaction.Transactional;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

	@Transactional
	@Modifying
	@Query("update UserLogin set password =:password where email =:email")
	public void updatePassword(String password, String email);
	
	@Transactional
	@Modifying
	@Query("update UserLogin set accountStatus = :status where email =:email")
	public void updateAccountStatus(String status, String email);
	
	@Query("select email from UserLogin where email = :email")
	public String getEmail(String email);
	
	@Query("select password from UserLogin where email =:email")
	public String getPassword(String email);
	
	@Query("select accountStatus from UserLogin where email =:email")
	public String getAccountStatus(String email);
}
