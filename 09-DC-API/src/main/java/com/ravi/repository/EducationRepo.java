package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.EducationEntity;

public interface EducationRepo extends JpaRepository<EducationEntity, Integer> {

	public EducationEntity findByCaseNumber(Integer caseNumber);
}
