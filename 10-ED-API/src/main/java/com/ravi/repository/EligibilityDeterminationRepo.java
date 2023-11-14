package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.EligibilityDeterminationEntity;

public interface EligibilityDeterminationRepo extends JpaRepository<EligibilityDeterminationEntity, Integer> {

	public EligibilityDeterminationEntity findByCaseNumber(Integer caseNumber);
	
}
