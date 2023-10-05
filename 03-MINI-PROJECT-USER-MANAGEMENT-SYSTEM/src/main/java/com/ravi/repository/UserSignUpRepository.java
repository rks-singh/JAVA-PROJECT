package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ravi.entitymodel.UserSignUp;

public interface UserSignUpRepository extends JpaRepository<UserSignUp, Integer> {

	@Query("from UserSignUp where email =:email")
	public UserSignUp findByEmail(String email);
}
