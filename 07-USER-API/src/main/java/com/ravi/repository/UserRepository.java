package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	public UserEntity findByEmail(String email);
}
