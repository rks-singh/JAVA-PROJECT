package com.ravi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.CitizenRegistrationEntity;

public interface CitizenRegistrationRepo extends JpaRepository<CitizenRegistrationEntity, Integer> {

	public CitizenRegistrationEntity findBycitizenSsn(Long ssn);
	
	public List<CitizenRegistrationEntity> findByCreatedBy(Integer citizenId);
}
