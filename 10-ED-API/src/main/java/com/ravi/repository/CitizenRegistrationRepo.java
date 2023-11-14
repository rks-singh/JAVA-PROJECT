package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.CitizenRegistrationEntity;

public interface CitizenRegistrationRepo extends JpaRepository<CitizenRegistrationEntity, Integer> {

}
