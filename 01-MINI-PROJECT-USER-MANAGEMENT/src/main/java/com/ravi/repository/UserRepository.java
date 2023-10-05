package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ravi.entity.UserAccount;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<UserAccount, Integer> {

	// ====== Custom Query to UpdateUserAccount Status ========
	@Modifying
	@Transactional
	@Query("update UserAccount set activeSwitch=:status where id=:userId")
	public void updateUserAccountStatus(Integer userId, String status);

	@Query("Select activeSwitch from UserAccount where id = :id ")
	public String getUserActiveSwitch(Integer id);
}
